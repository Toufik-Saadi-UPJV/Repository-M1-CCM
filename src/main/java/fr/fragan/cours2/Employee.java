package fr.fragan.cours2;

import lombok.Getter;
import lombok.Setter;

public class Employee {

    @Getter
    public static int id = 0;

    @Getter @Setter
    private Agenda agenda;

    @Getter @Setter
    private boolean endedTasks = false;

    public Employee() {

        id++;

    }

    public void refresh() {

        this.endedTasks = this.agenda.isDone();

    }

    public boolean hasEndedTasks() {

        return this.agenda.isDone();

    }

    public void endAllTasks() {

        this.agenda.getTasks().forEach(task -> {

            task.setDone(true);
            System.out.println("Employee number : " + id + " end task : " + task.getLabel());

        });

        this.refresh();

    }

    @Override
    public String toString() {
        return "Employee{" +
                "agenda=" + agenda +
                ", endedTasks=" + endedTasks +
                '}';
    }
}
