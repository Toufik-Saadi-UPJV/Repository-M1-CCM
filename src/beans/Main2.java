package beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        genericMethod(50);

        Task a,b,c,d;
        Thread TA,TB,TC,TD;

        c = new Task("C", null);
        TC = new Thread(c, "T" + c.getLabel());

        b = new Task("B", TC);
        TB = new Thread(b, "T" + b.getLabel());

        a = new Task("A", TB);
        TA = new Thread(a, "T" + a.getLabel());

        d = new Task("D", TA);
        TD = new Thread(d, "T" + d.getLabel());

        //Q5 le problème est que cela va créer un interbloquage et donc le programme ne s'arrettera jamais.
        c.setPredecesseur(TD);
        TA.start();
        TB.start();
        TC.start();
        TD.start();


    }


    public static void genericMethod(int n){
        List<Thread> threadList = new ArrayList<>();
        if(n>0){
            Task t = new Task("T"+n);
            threadList.add(new Thread(t));
            for(int i=1; i<n; i++){
                Task task = new Task("T"+(n-i) ,threadList.get(i-1));
                threadList.add(new Thread(task));
            }
        }
        Collections.reverse(threadList);
        for (Thread t:threadList) {
            t.start();
        }
    }
}
