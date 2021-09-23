package com.company;

public class Employe {

    protected static String name;
    protected static Agenda a;

    public Employe(String name) {
        a = new Agenda();
        Employe.name = name;
    }
    public static Agenda getAgenda() {
        return a;
    }

}
