package com.company;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    protected ArrayList<Tache> listTache = new ArrayList<>();


    public ArrayList<Tache> getListTache() {
        return listTache;
    }
    public ArrayList<Tache> tachesFaites(ArrayList<Tache> listTache) {
        ArrayList<Tache> listFait = new ArrayList<>();
        for (com.company.Tache Tache : listTache) {
            if (Tache.getFait()) {
                listFait.add(Tache);
            }
        }
        return listFait;
    }

    public ArrayList<Tache> getListTacheByDate(int jour) {
        ArrayList<Tache> listByDate = new ArrayList<>();
        for (com.company.Tache tache : listTache) {
            if (tache.getDate() == jour) {
                listByDate.add(tache);
            }
        }
        return listByDate;
    }

    public Tache addTache(int jour, int priorite, String libelle) {
        return new Tache(jour, priorite, libelle);
    }
}
