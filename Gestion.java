package com.company;


import com.company.Employes;

import java.io.*;
import java.net.Socket;

public class Gestion implements Runnable {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private Employes employee;

    public Gestion(Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new
                InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        employee = new Employes();
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!reader.readLine().equals("")) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        writer.println("Votre agenda :\n" + employee.getAgenda());

        writer.flush();
        writer.close();
    }
}
