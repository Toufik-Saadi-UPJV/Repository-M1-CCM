package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() {
        try {
            ServerSocket instance = new ServerSocket(6666, 10);
            while (true) {
                Socket socket = null;
                try {
                    socket = instance.accept();
                    while (true) {
                        System.out.println(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine());
                    }

                } catch (IOException e) {
                    System.out.println("L'instance ne s'est pas lancé (Erreur: " + e + ")");
                }
                new Thread(new GestionClient(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Serveur non instancié : " + e);
        }
    }
}
