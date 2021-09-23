package com.company;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8015, 10);
            while (true){
                new Thread(new Gestion(serverSocket.accept())).start();
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
