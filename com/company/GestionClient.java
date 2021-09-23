package com.company;

import java.net.Socket;
import java.util.ArrayList;

public class GestionClient implements Runnable {

    protected Socket socket;

    public GestionClient(Socket s) {
        this.socket = s;
    }

    public void run() {

    }
}
