package com.company;

public class Tache {


    protected int jour = 0;
    protected int priorite = 0;
    protected String libelle = "";
    protected boolean fait = false;

    public Tache(int date, int priorite, String libelle) {
        this.jour = date;
        this.priorite = priorite;
        this.libelle = libelle;
    }

    public int getDate() {
        return jour;
    }
    public void setDate(int jour) {
        this.jour = jour;
    }

    public int getPriorite() {
        return priorite;
    }
    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean getFait() { return fait; }
    public void setFait(boolean fait) {
        this.fait = fait;
    }

}
