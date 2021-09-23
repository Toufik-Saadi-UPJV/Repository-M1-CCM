package beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static synchronized int getNbEmployee() {
        nbEmployee++;
        return nbEmployee;
    }

    private static int nbEmployee;

    public static void main(String[] args) {
        List<Task> listOfTasks = new LinkedList<>();
        Agenda agenda = new Agenda();

        Task t1 = new Task();
        t1.setDone(false);
        t1.setLabel("Task1");
        t1.setPriority(0);
        t1.setStart_date(LocalDateTime.now());

        t1.addPropertyChangeListener(event -> System.out.println("propertyChange : valeur = " + event.getNewValue())
        );

        Task t2 = new Task();
        t2.setDone(false);
        t2.setLabel("Task2");
        t2.setPriority(1);
        t2.setStart_date(LocalDateTime.now());

        listOfTasks.add(t1);
        listOfTasks.add(t2);

        agenda.setListOfTasks(listOfTasks);

        System.out.println(agenda);
        t1.setDone(true);
        System.out.println(agenda.getDoneTasks());
        List<Employee> employeeList = new ArrayList<>();
        List<ThreadCreateEmployee> threadCreateEmployeeArrayList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            ThreadCreateEmployee createEmployee = new ThreadCreateEmployee();
            Thread t = new Thread(createEmployee);
            t.start();
            threadCreateEmployeeArrayList.add(createEmployee);
        }


        try {
            ServerSocket serversocket = new ServerSocket(4444, 10);
            while (true) {
                Socket socket = serversocket.accept();
                System.out.println("Connected to " + socket.getLocalAddress());
                GestionClient gc = new GestionClient(socket, agenda);
                new Thread(gc).start();
                employeeList.add(gc.getEmployee());
                System.out.println("List Of Employee : " + employeeList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
