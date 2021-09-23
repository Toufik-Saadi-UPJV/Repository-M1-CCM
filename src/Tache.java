import java.time.LocalDateTime;

public class Tache implements Runnable{
    private String libelle;
    private int priorite;
    private LocalDateTime date;
    public boolean effectuee;
    public Thread predecesseur;

    public Tache(String libelle, int priorite, LocalDateTime date, boolean effectuee){
        super();
        this.setLibelle(libelle);
        this.setPriorite(priorite);
        this.setDate(date);
        this.setEffectuee(effectuee);
    }

    public Tache(String libelle)
    {
        //Question 1: Seance 3
        this.libelle = libelle;
    }


    public Tache(String libelle, Thread predecesseur){
        //Question 3
        this.libelle = libelle;
        this.predecesseur = predecesseur;
    }

    public void setPredecesseur(Thread predecesseur)
    {
        this.predecesseur = predecesseur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isEffectuee() {
        return effectuee;
    }

    public void setEffectuee(boolean effectuee) {
        this.effectuee = effectuee;
    }


    @Override
    public void run() {
        if(predecesseur != null)
        {
            try{
                predecesseur.join();
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
        System.out.println("Tâche : " + libelle + " terminée");
    }
}
