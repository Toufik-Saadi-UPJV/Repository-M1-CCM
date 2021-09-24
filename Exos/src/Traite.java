import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Traite extends Thread {
    private String nom;
    private double vitesse;
    private List<Tache> taches;
    private List<Tache> tachesAttendu;

    public Traite(String nom, double vitesse) {
        taches = new ArrayList<>();
        tachesAttendu = new ArrayList<>();
        this.nom = nom;
        this.vitesse = vitesse;
        System.out.println("debut:" + nom);
    }

    public void run() {
        System.out.println("Début:" + nom );
        while (verifierT()) {
            try {
                sleep((int) vitesse * 2000);
                finirTache();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Erreur" + nom);
            }
        }
    }


    public void ajouterT(Tache tache) {
        tache.setMachine(this);
        taches.add(tache);
        Collections.sort(taches);
    }

    public void ajouterTAttendu(Tache tache) {
        tachesAttendu.add(tache);
        Collections.sort(tachesAttendu);
    }

    public boolean verifierT() {
        for (Tache tache : taches) {
            if (!tache.isFinir())
                return true;
        }
        return false;
    }


    public void finirTache() {
        if (verifierTachesAttendues()) {
            for (Tache tache : taches) {
                if (!tache.isFinir()) {
                    tache.finir();
                    return;
                }
            }
        }
    }

    public boolean verifierTachesAttendues() {
        for (Tache tache : tachesAttendu) {
            if (!tache.isFinir())
                return false;
        }
        return true;
    }


    // Getters
    public String getNom() { return nom; }
    public double getVitesse() { return vitesse; }
}