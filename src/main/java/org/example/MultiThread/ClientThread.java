package org.example.MultiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientThread implements Runnable{

    @Override
    public void run() {
        int port = 5000;
        try{
            InetAddress address = InetAddress.getByName("localhost");
            Socket socket = new Socket(address,port);

            BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter toSocket = new PrintWriter(socket.getOutputStream());

            toSocket.println("Hello from Client...!");
            String message = fromSocket.readLine();
            System.out.println("Response from server " + message);
//            Thread.sleep(5000);
            String message1 = fromSocket.readLine();
            System.out.println("Response from server " + message1);
            toSocket.close();
            fromSocket.close();
            socket.close();
        }
        catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        catch (IOException e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
