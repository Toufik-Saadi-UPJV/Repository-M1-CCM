import fr.fragan.cours2.Agenda;
import fr.fragan.cours2.CustomerManager;
import fr.fragan.cours2.Employee;
import fr.fragan.cours2.Task;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        Task task1 = new Task();
        task1.setLabel("Tache n°1");
        task1.setPriority(1);
        task1.setDate(new Date());

        task1.addPropertyChangeListener(evt -> System.out.println("Property changed (" + evt.getPropertyName() + ") : " + evt.getNewValue()));

        Task task2 = new Task();
        task2.setLabel("Tache n°2");
        task2.setPriority(2);
        task2.setDate(new Date());

        agenda.addTask(task1);
        agenda.addTask(task2);

        List<Employee> employeeList = new ArrayList<>();

        try {

            ServerSocket serverSocket = new ServerSocket(3000, 10);

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("Connection established successfuly (Address : " + serverSocket.getLocalSocketAddress() + ")");

                CustomerManager customerManager = new CustomerManager(socket, agenda);

                new Thread(customerManager).start();

                employeeList.add(customerManager.getEmployee());

                System.out.println("Employees list : " + employeeList);

            }


        } catch (IOException e) {

            e.printStackTrace();

        }


    }

}
