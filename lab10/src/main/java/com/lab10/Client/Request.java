package com.lab10.Client;

import com.lab10.Commands.Command;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Request {
    private final Socket socket;

    public Request(Socket socket) {
        this.socket = socket;
    }

    public String getRequestResponse(String request) throws IOException {

        ObjectOutputStream OOS = new ObjectOutputStream(
                socket.getOutputStream());

        BufferedReader in
                = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));

        OOS.writeObject(new Command(request));

        try {
            String line = in.readLine();
            StringBuilder response = new StringBuilder();

            while(!line.equals("END")) {
                response.append(line);
                response.append("\n");
                line = in.readLine();
            }

            return response.toString();


        }  catch (SocketException e){

            return "SOCKET_TIMEOUT";

        } catch (Exception e){

            e.printStackTrace();

        } finally {

            socket.close();

        }

        return null;
    }
}
