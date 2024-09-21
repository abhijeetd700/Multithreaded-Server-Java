package org.example.ThreadPool;

import org.example.MultiThread.Worker;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {
        int port = 8000;
        int poolSize = 20;

        final ExecutorService executorService = Executors.newCachedThreadPool();

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            serverSocket.setSoTimeout(600000);
            while (true) {
                try {
                    System.out.println("Server is listning on port " + port);
                    Socket socket = serverSocket.accept();
                    executorService.execute(new Worker(socket));
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
