package aaa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Agenda {

    public  ArrayList<Task> tasks = new ArrayList<Task>();

    public void createTask(String libele, int priorite, boolean effectue){
        tasks.add(new Task(libele,priorite,effectue));
    }

    public List<Task> getEndedTask() {
        return tasks.stream().filter(Task::isEffectue).collect(Collectors.toList());
    }

    public List<Task> getTaskByDate(Date date) {
        return tasks.stream().filter(task -> task.getDateTime().equals(date)).collect(Collectors.toList());
    }

}