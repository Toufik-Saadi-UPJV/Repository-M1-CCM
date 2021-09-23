package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Employes {
    private Agenda agenda;

    public Employes() {
        Tache tache = new Tache("Tache", 1, LocalDateTime.now());
        Tache tache1 = new Tache("Tache1", 2, LocalDateTime.now());

        Agenda agenda = new Agenda();
        agenda.setListTaches(
                new ArrayList<Tache>(Arrays.asList(
                        tache,
                        tache1
                ))
        );

        this.setAgenda(agenda);
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
        return "Employes{" +
                "agenda=" + agenda +
                '}';
    }
}
