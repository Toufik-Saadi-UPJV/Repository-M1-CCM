package com.company;

import java.time.LocalDateTime;

public class Tache {
    private String libelle;

    private int priorite;

    private LocalDateTime dateDebut;

    private boolean effectuee;

    public Tache(String libelle, int priorite, LocalDateTime dateDebut, boolean effectuee)
    {
        this.libelle = libelle;
        this.priorite = priorite;
        this.dateDebut = dateDebut;
        this.effectuee = effectuee;
    }

    public Tache(String libelle, int priorite, LocalDateTime dateDebut) {
        this(libelle, priorite, dateDebut, false);
    }

    public boolean getEffectuee() {
        return this.effectuee;
    }

    public LocalDateTime getDateDebut() {
        return this.dateDebut;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "libelle='" + libelle + '\'' +
                ", priorite=" + priorite +
                ", dateDebut=" + dateDebut +
                ", effectuee=" + effectuee +
                '}';
    }
}
