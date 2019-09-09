import java.util.ArrayList;

public class TaskList {
    public ArrayList<Task> taskList = new ArrayList<Task>(100);

    public TaskList() {
        this.taskList = new ArrayList<Task>(100);
    }

    public TaskList(ArrayList<Task> List) {
        for (Task t: List) {
            taskList.add(t);
        }
    }
}
