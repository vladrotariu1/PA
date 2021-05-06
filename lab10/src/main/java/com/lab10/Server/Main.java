package com.lab10.Server;

import com.lab10.Server.Exceptions.SocketNotInitializedException;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(3002);
        ExecutorService pool = Executors.newFixedThreadPool(10);

        while (true) {
            System.out.println("Waiting connection...");
            Socket client = listener.accept();
            client.setSoTimeout(120000);
            System.out.println("Connection accepted");

            ConnectionHandler connection = new ConnectionHandler(client);
            pool.submit(connection);
        }
    }
}