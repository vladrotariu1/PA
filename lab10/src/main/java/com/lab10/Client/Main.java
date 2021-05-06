package com.lab10.Client;

import java.io.IOException;
import java.net.Socket;
import java.util.*;

class Main {

    static final Scanner userInput = new Scanner(System.in);

    private static boolean stopClient(String response) {
        return response.equals("SOCKET_TIMEOUT") || response == null;
    }

    public static void main(String[] args) throws IOException {
        while(true) {
            Request requestHandler = new Request(new Socket("localhost", 3002));
            String request = userInput.nextLine();
            String response = requestHandler.getRequestResponse(request);

            if (stopClient(response)) {
                System.out.println("Error. Perhaps due to server timeout.");
                break;
            } else {
                System.out.println(response);
            }
        }
    }
}
