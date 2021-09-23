package fr.fragan.cours2;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.net.Socket;

public class CustomerManager implements Runnable {

    private final Socket socket;

    private final BufferedReader reader;

    private PrintWriter writer;

    @Getter @Setter
    private Employee employee;

    public CustomerManager(Socket socket, Agenda agenda) throws IOException {

        this.socket = socket;

        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        this.writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        this.employee = new Employee();

        this.employee.setAgenda(agenda);
    }

    @Override
    public void run() {

        String dataReceived = "";

        while (true) {

            try {

                dataReceived = this.reader.readLine();

                if (!dataReceived.equals("")){

                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.writer.println("Employee : " + this.employee.toString());
        this.writer.println("Agenda :\n" + employee.getAgenda().toString());

        this.writer.flush();
        this.writer.close();

    }
}