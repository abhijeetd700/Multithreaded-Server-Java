package org.example.SingleThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port = 5000;

    public void run() throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(600000);
        while (true){
            try {
                System.out.println("Server is listning on port "+port);
                //The program will stop at below line unless some req comes from client & after 60sec, it the server port will be closed
                Socket socket = serverSocket.accept();
//                Client ------------ Server
//        (in)fromClient-->     <-- toClient(out)
                Thread.sleep(2000);
                System.out.println("Connection accepted from client "+socket.getRemoteSocketAddress());

//                PrintWriter toCilent = new PrintWriter(socket.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                toCilent.println("Hello from Server..!");
//                toCilent.close();
                fromClient.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {
        Server server = new Server();
        try{
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
