package com.lab10.Server;

import com.lab10.Commands.*;
import com.lab10.Commands.CommunicationObjects.Command;
import com.lab10.Commands.CommunicationObjects.Cookie;
import com.lab10.Commands.CommunicationObjects.Response;
import com.lab10.Commands.Exceptions.FriendYourselfException;
import com.lab10.Commands.Exceptions.InvalidNumberOfParametersException;
import com.lab10.Server.Exceptions.SocketNotInitializedException;

import javax.persistence.NoResultException;
import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;


public class ConnectionHandler implements Runnable{
    private final Socket socket;
    private final ObjectInputStream in;
    private final ObjectOutputStream out;

    ConnectionHandler(Socket socket) throws IOException {
        this.socket = socket;
        in = new ObjectInputStream(this.socket.getInputStream());
        out = new ObjectOutputStream(this.socket.getOutputStream());
    }

    private Response executeRequest(Command request) {
        String command = request.getCommand();
        ArrayList<String> arguments = request.getArguments();
        Cookie requestCookie = request.getCookie();

        switch (command.toLowerCase()) {
            case "register":

                try {
                    new RegisterShellCommand(arguments).execute();
                    return new Response("Successfully registered", null);

                } catch (InvalidNumberOfParametersException e) {
                    return new Response("Command should be:\nregister <username>", null);

                } catch (Exception e) {
                    return new Response("Database error. Couldn't create new user", null);
                }

            case "login":

                if (requestCookie.loggedUserId() != -1)
                    return new Response("You are already logged in", null);

                try {
                    int userId = new LoginShellCommand(arguments).execute();
                    Cookie cookie = new Cookie();
                    cookie.addInfo("logged", String.valueOf(userId));
                    return new Response("Logged in", cookie);

                } catch (NoResultException e) {
                    e.printStackTrace();
                    return new Response("Invalid user", null);

                } catch (InvalidNumberOfParametersException e) {
                    e.printStackTrace();
                    return new Response("Command should be:\nlogin <username>", null);

                } catch (Exception e) {
                    e.printStackTrace();
                    return new Response("Database error", null);
                }

            case "friend":

                if (requestCookie.loggedUserId() == -1)
                    return new Response("First you have to login", null);

                try {
                    int userId = requestCookie.loggedUserId();
                    new FriendShellCommand(arguments).execute(userId);
                    return new Response("Friendship created", null);

                } catch (FriendYourselfException e) {
                    e.printStackTrace();
                    return new Response("Cannot create friendship with yourself", null);

                } catch (NoResultException e) {
                    e.printStackTrace();
                    return new Response("This person does not exist", null);
                } catch (InvalidNumberOfParametersException e) {
                    e.printStackTrace();
                    return new Response("Command should be:\nfriend <username>", null);

                } catch (Exception e) {
                    e.printStackTrace();
                    return new Response("Database error", null);
                }

            case "message":

                if (requestCookie.loggedUserId() == -1)
                    return new Response("First you have to login", null);

                try {
                    int userId = requestCookie.loggedUserId();
                    new MessageShellCommand(arguments).execute(userId);
                    return new Response("Message sent", null);

                } catch (NoResultException e) {
                    e.printStackTrace();
                    return new Response("Couldn't find this person in friend-list", null);

                } catch (InvalidNumberOfParametersException e) {
                    e.printStackTrace();
                    return new Response("Command should be:\nmessage <username> <message>", null);

                } catch (Exception e) {
                    e.printStackTrace();
                    return new Response("Unexpected exception", null);
                }

            case "showmsg":

                if (requestCookie.loggedUserId() == -1)
                    return new Response("First you have to login", null);

                try {
                    int userId = requestCookie.loggedUserId();
                    String inbox = new ShowmsgShellCommand(arguments).execute(userId);
                    System.out.println(inbox);
                    return new Response(inbox, null);

                } catch (InvalidNumberOfParametersException e) {
                    e.printStackTrace();
                    return new Response("Command has no parameters", null);
                }

            default:
                return new Response("Invalid command", null);
        }
    }

    private Command getRequest() throws SocketNotInitializedException, IOException, ClassNotFoundException {
        if (socket == null)
            throw new SocketNotInitializedException("Socket not initialized");

        return (Command) in.readObject();
    }

    private void sendResponse(Command request) throws SocketNotInitializedException, InterruptedException, IOException {
        if (socket == null)
            throw new SocketNotInitializedException("Socket not initialized");

        Response executionResult = executeRequest(request);

        out.writeObject(executionResult);
    }

    @Override
    public void run() {
        try {

            Command request = getRequest();
            System.out.println(request);
            sendResponse(request);

        } catch (SocketTimeoutException e) {

            System.out.println("Socket closed");

        } catch (SocketNotInitializedException | IOException | InterruptedException | ClassNotFoundException e) {

            e.printStackTrace();

        } finally {

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
