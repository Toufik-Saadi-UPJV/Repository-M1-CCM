package S3;

public class Tache implements Runnable {
    private String texte;
    private Thread threadPrecedent;

    public Tache(String texte, Thread threadPrecedent) {
        this.texte = texte;
        this.threadPrecedent = threadPrecedent;
    }

    public void setThreadPrecedent(Thread threadPrecedent) {
        this.threadPrecedent = threadPrecedent;
    }

    public Tache(String texte) {
        this(texte, null);
    }

    public void run() {
        System.out.println("Tache:" + this.texte);
        if (this.threadPrecedent != null) {
            try {
                this.threadPrecedent.join();
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }
        }

        System.out.println("La tache " + this.texte + " est terminee");
    }
}
