package org.example.MultiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.Callable;

public class Worker implements Runnable {
    private final Socket socket;

    public Worker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Connection accepted from client "+socket.getRemoteSocketAddress());
//            PrintWriter toClient = new PrintWriter(socket.getOutputStream());
//            BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(Thread.currentThread().getName()+" is running");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" is complete");
//           toClient.close();
//           fromClient.close();
           this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
