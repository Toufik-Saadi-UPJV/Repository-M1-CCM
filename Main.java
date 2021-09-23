package aaa;

public class Main {
    public static void main(String[] args) {
        Employe thread1=new Employe();
        Employe thread2=new Employe();
        thread1.start();
        thread2.start();
        
    }
}
