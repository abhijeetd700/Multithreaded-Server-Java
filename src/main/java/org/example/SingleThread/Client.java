package org.example.SingleThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Client {

    public void run() throws IOException {
        int port = 5000;
        InetAddress address = InetAddress.getByName("localhost");
        try (Socket socket = new Socket(address,port)){

            // Client ------------ Server
//              toSocket-->     <-- fromSocket
            BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter toSocket = new PrintWriter(socket.getOutputStream());

            toSocket.println("Hello from Client...!");
            String message = fromSocket.readLine();
            System.out.println("Response from server = " + message);
            toSocket.close();
            fromSocket.close();
            socket.close();
        }
        catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        }
        catch (IOException e){
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        try{
            client.run();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
