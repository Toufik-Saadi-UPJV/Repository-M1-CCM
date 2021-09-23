package Exo_2;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[]args) {

        Thread TC = new Thread(new Task(), "TC");
        Thread TB = new Thread(new Task(new ArrayList<>(Arrays.asList(TC))), "TB");
        Thread TA = new Thread(new Task(new ArrayList<>(Arrays.asList(TB))), "TA");
        TC.start();
        System.out.println("TC start");
        TB.start();
        System.out.println("TB start");
        TA.start();
        System.out.println("TA start");
    }
}
