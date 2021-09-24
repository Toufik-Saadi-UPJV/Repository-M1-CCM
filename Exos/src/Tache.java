public class Tache implements Comparable<Tache> {
    private String nom;
    private Traite traite;
    private boolean finir;
    private int ordre;

    public Tache(String nom, char ordre) {
        this.nom = nom;
        this.ordre = (int) ordre;
        finir = false;
    }


    public void finir() {
        System.out.println("Fin de" + nom + "  // Thread:" + traite.getNom() + "\"");
        finir = true;
    }

    @Override
    public int compareTo(Tache cible) {
        return (this.ordre - cible.ordre);
    }


    public String getNom() { return nom; }
    public boolean isFinir() { return finir; }
    public Traite isMachine() { return traite; }
    public void setNom(String libelle) { this.nom = nom; }
    public void setMachine(Traite traite) { this.traite = traite; }
}