import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tache_s3{
    public static void main(String[] args) {

        //Question 2 : Création des thread
        Tache A, B, C, D;
        Thread TA, TB, TC, TD;

        //Question 4
        C= new Tache("C", null);
        TC = new Thread(C, "T" + C.getLibelle());

        //Question 4
        B = new Tache("B", TC);
        TB = new Thread(B, "T" + B.getLibelle());

        //Question 4
        A = new Tache("A", TB);
        TA = new Thread(A, "T" + A.getLibelle());

//        Question 5
//        D = new Tache("B", TA);
//        TD = new Thread(D, "T" + D.getLibelle());
//        C.setPredecesseur(TD);

        //Question 4
        TA.start();
        TB.start();
        TC.start();
        //Question 5
//        TD.start();
    }
}
