package com.lab10.Client;

import com.lab10.Commands.CommunicationObjects.Command;
import com.lab10.Commands.CommunicationObjects.Cookie;
import com.lab10.Commands.CommunicationObjects.Response;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class Request {
    private final Socket socket;

    public Request(Socket socket) {
        this.socket = socket;
    }

    public Response getRequestResponse(String request, Cookie cookie) throws IOException {

        ObjectOutputStream OOS = new ObjectOutputStream(
                socket.getOutputStream());

        ObjectInputStream OIS = new ObjectInputStream(
                socket.getInputStream());

        Command command = new Command(request);
        command.setCookie(cookie);
        OOS.writeObject(command);

        try {
            return (Response) OIS.readObject();

        }  catch (SocketException e){
            return new Response("SOCKET_TIMEOUT", null);

        } catch (Exception e){
            e.printStackTrace();
            return new Response("Unexpected Error", null);

        } finally {
            socket.close();
        }
    }
}
