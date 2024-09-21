package org.example.MultiThread;

public class Client {

    public static void main(String[] args) {

        for(int i=0;i<5;i++){
            Thread t = new Thread(new ClientThread());
            t.start();
        }

    }
}
