package Exo_2;

import java.util.ArrayList;

public class Task implements Runnable{

    protected ArrayList<Thread> thread;

    public Task() {

    }
    public Task(ArrayList<Thread> Thread) {
        this.thread = Thread;
    }

    public void run() {
        if (thread != null) {
            if (!thread.isEmpty()) {
                System.out.println("J'attends mon pote");
                try {
                    thread.get(0).join();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println("Mon pote a fini, donc J'ai fini !");
            }
        }
        else {

            System.out.println("Pas de Thread à attendre pour donc j'ai fini !");
        }
    }
}
