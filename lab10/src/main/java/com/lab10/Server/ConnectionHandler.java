package com.lab10.Server;

import com.lab10.Commands.Command;
import com.lab10.Server.Exceptions.SocketNotInitializedException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class ConnectionHandler implements Runnable{
    private final Socket socket;
    private final ObjectInputStream in;
    private final PrintWriter out;

    ConnectionHandler(Socket socket) throws IOException {
        this.socket = socket;
        in = new ObjectInputStream(this.socket.getInputStream());
        out = new PrintWriter(this.socket.getOutputStream(), true);
    }

    private String executeRequest(String command, ArrayList<String> arguments) {

        /*switch (command) {

        }*/

        return "Command executed";

    }

    private Command getRequest() throws SocketNotInitializedException, IOException, ClassNotFoundException {
        if (socket == null)
            throw new SocketNotInitializedException("Socket not initialized");

        return (Command) in.readObject();
    }

    private void sendResponse(Command request) throws SocketNotInitializedException, InterruptedException {
        if (socket == null)
            throw new SocketNotInitializedException("Socket not initialized");

        String executionResult = executeRequest(request.getCommand(), request.getArguments());

        out.println(executionResult);
        out.println("END");
        out.flush();
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
