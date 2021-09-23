package fr.fragan.cours2;

import lombok.Getter;
import lombok.Setter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

public class Task {

    @Getter @Setter
    private String label;

    @Getter @Setter
    private int priority;

    @Getter @Setter
    private Date date;

    @Getter @Setter
    private boolean isDone;

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Task() {

        super();

        this.isDone = false;

    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void setDone(boolean done) {

        boolean before = this.isDone;

        this.isDone = done;

        this.propertyChangeSupport.firePropertyChange("isDone", before, done);

    }

    @Override
    public String toString() {
        return "Task{" +
                "label='" + label + '\'' +
                ", priority=" + priority +
                ", date=" + date +
                ", isDone=" + isDone +
                ", propertyChangeSupport=" + propertyChangeSupport +
                '}';
    }
}
