package com.lab10.Client;

import com.lab10.Commands.CommunicationObjects.Cookie;
import com.lab10.Commands.CommunicationObjects.Response;

import java.io.IOException;
import java.net.Socket;
import java.util.*;

class Main {

    static final Scanner userInput = new Scanner(System.in);
    static Cookie cookie = new Cookie();

    private static boolean stopClient(String response) {
        return response.equals("SOCKET_TIMEOUT");
    }

    public static void main(String[] args) throws IOException {
        while(true) {
            String request = userInput.nextLine();
            Request requestHandler = new Request(new Socket("localhost", 3002));
            Response response = requestHandler.getRequestResponse(request, cookie);
            cookie = response.getCookie() == null ? cookie : response.getCookie();

            if (stopClient(response.getMessage())) {
                System.out.println("Error. Perhaps due to server timeout.");
                break;
            } else {
                System.out.println(response.getMessage());
            }
        }
    }
}
