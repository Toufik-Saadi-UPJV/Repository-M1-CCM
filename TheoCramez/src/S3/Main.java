package S3;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int iteration = 0;

        try {
            iteration = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.exit(-1);
        }

        Thread precedentThread = null;

        for(int i = 0; i < iteration; ++i) {
            Thread thread = new Thread(new Tache(Integer.toString(i), precedentThread));
            precedentThread = thread;
            thread.start();
        }
    }
}