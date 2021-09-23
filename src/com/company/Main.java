package com.company;

public class Main {
    public static void main(String[] args) {
        //region Partie1
        /*
        Task tCTask = new Task("c");
        Thread tC = new Thread(tCTask);;
        Thread tB = new Thread(new Task("b", tC));
        Thread tA = new Thread(new Task("a", tB));
        Thread tD = new Thread(new Task("d", tA));
        tCTask.setPreviousThread(tD);

        tC.start();
        tB.start();
        tA.start();
        tD.start();*/
        //endregion
        //region Partie2
        int iterate = 0;
        try {
            iterate = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.exit(-1);
        }

        Thread previous = null;
        for(int i = 0 ; i < iterate; i++) {
            Thread thread = new Thread(new Task(Integer.toString(i), previous));
            previous = thread;
            thread.start();
        }
        //endregion

    }
}
