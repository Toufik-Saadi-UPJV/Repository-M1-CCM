package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Agenda {
    private ArrayList<Tache> listTaches = new ArrayList<Tache>();

    public Agenda() {
        for(int i = 0 ; i < 4; i++) {
            Tache tache = new Tache("Libelle : " + i, i, LocalDateTime.now());
            listTaches.add(tache);
        }
    }


    public ArrayList<Tache> getListTaches() {
        return this.listTaches;
    }

    public void setListTaches(ArrayList<Tache> taches) {
        this.listTaches = taches;
    }

    public void addListTaches(Tache tache) {
        this.listTaches.add(tache);
    }

    public ArrayList<Tache> getDone() {
        ArrayList<Tache> dones = new ArrayList<Tache>();
        for (Tache tache: this.listTaches) {
            if (tache.getEffectuee()) {
                dones.add(tache);
            }
        }

        return dones;
    }

    public ArrayList<Tache> getByDate(String date) {
        ArrayList<Tache> byDate = new ArrayList<Tache>();
        LocalDateTime input = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        for (Tache tache: this.listTaches) {
            if (tache.getDateDebut().isEqual(input)) {
                byDate.add(tache);
            }
        }

        return byDate;
    }

    public void printAll(){
        for (Tache tache : this.listTaches) {
            System.out.println(tache);
        }
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "listTaches=" + listTaches +
                '}';
    }
}
