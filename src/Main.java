import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employe thread1=new Employe();
        thread1.setFname("to1to");
        thread1.start();
        System.out.println(thread1.agenda.getEndedTask().size());

        Employe thread2=new Employe();
        thread2.setFname("toto");
        thread2.start();



    }
}
