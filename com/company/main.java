package com.company;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[]args) throws IOException {

        Server s = new Server();
        Socket instance = new Socket("localhost", 6666);

    }
}

