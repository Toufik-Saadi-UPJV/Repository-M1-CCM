import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Exo1 {
    private int valeur;
    private float[] notes;

    public Exo1() {
        valeur = 0;
        notes = new float[5];

        System.out.println("Valeur : " + getValeur());

        setValeur(10);

        System.out.println("Valeur : " + getValeur());

        ajouterPropriete(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("Propriete du changement de valeur : " + evt.getNewValue());
            }
        });
    }

    // Events
    private void ajouterPropriete(PropertyChangeListener propriete) { }

    // Setters
    public void setValeur(int valeur) { this.valeur = valeur; }
    public void setNotes(float[] notes) { this.notes = notes; }
    public int getValeur() { return this.valeur; }
    public float[] getNotes() { return this.notes; }
}