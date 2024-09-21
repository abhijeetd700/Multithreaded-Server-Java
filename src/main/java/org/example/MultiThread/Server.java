package org.example.MultiThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

public class Server {

    private static int port = 6000;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            serverSocket.setSoTimeout(600000);
            while (true) {
                try {
                    System.out.println("Server is listning on port " + port);
                    Socket socket = serverSocket.accept();
                    Thread t = new Thread(new Worker(socket));
                    t.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
