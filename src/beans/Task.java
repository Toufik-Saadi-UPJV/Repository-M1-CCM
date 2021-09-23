package beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDateTime;

public class Task implements Runnable {
    private String label;
    private int priority;
    private LocalDateTime start_date;
    private boolean isDone;
    private Thread predecesseur;

    public Task() {
    }

    public void setPredecesseur(Thread predecesseur) {
        this.predecesseur = predecesseur;
    }

    public Task(String name) {
        this.label = name;
    }

    public Task(String name, Thread t) {
        this(name);
        predecesseur = t;
    }

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);



    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Task : " + label + "\n" +
                "priority : " + priority + "\n" +
                "start_date : " + start_date + "\n" +
                "isDone : " + isDone + "\n\n";
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean newValue) {
        boolean oldValue = this.isDone;
        this.isDone = newValue;
        this.pcs.firePropertyChange("isDone", oldValue, newValue);
    }

    @Override
    public void run() {
        if(predecesseur != null){
            try {
                predecesseur.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Je suis la tache : " + label + " et j'ai finis !");
    }
}
