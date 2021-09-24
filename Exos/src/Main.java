import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String args[]) {

        Tache TA = new Tache("TA", 'A');
        Tache TB = new Tache("TB", 'B');
        Tache TC = new Tache("TC", 'C');
        Traite TH1 = new Traite("TH1", 4.0);
        Traite TH2 = new Traite("TH2", 3.0);
        Traite TH3 = new Traite("TH3", 2.0);

        TH1.ajouterT(TA);
        TH2.ajouterT(TB);
        TH2.ajouterTAttendu(TA);

        TH3.ajouterTAttendu(TA);
        TH3.ajouterTAttendu(TB);
        TH3.ajouterT(TC);

        try {
            TH1.start();
            TH2.start();
            TH3.start();
            TH1.join();
            TH2.join();
            TH3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}