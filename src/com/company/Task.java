package com.company;

import java.util.List;

public class Task implements Runnable
{
    private String text;
    private Thread previousThread;

    /**
     *
     * @param text String
     * @param previousThread Thread
     */
    public Task(String text, Thread previousThread){
        this.text = text;
        this.previousThread = previousThread;
    }

    /**
     *
     * @param text String
     */
    public Task(String text) {
        this(text, null);
    }

    public void setPreviousThread(Thread previousThread) {
        this.previousThread = previousThread;
    }

    /**
     *
     */
    @Override
    public void run() {
        System.out.println("Je suis la tache : " + text);
        if (previousThread != null) {
            try {
                //on attends la fin de l'execution du thread precédent
                previousThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("tache : " + text + " over");
    }
}
