package fr.fragan.cours2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Agenda {

    @Getter
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public List<Task> getEndedTask() {

        return this.tasks.stream().filter(Task::isDone).collect(Collectors.toList());

    }

    public List<Task> getTaskByDate(Date date) {

        return this.tasks.stream().filter(task -> task.getDate().equals(date)).collect(Collectors.toList());

    }

    public boolean isDone() {

        return this.tasks.size() == this.getEndedTask().size();

    }

    public void addTask(Task task) {

        this.tasks.add(task);

    }

    public void removeTask(Task task) {

        this.tasks.remove(task);

    }

    @Override
    public String toString() {
        return "Agenda{" +
                "tasks=" + tasks +
                '}';
    }
}
