import java.util.ArrayList;

public class TaskList {
    public ArrayList<Task> taskList = new ArrayList<Task>(100);

    public TaskList() {
        this.taskList = new ArrayList<Task>(100);
    }

    public TaskList(ArrayList<Task> List) {
        for (Task t: List) {
            addToList(t);
        }
    }

    public int getSize() {
        return taskList.size();
    }

    public void addToList(Task input) {
        taskList.add(input);
    }

    public void removeFromList(int i) throws ArrayIndexOutOfBoundsException{
        taskList.remove(i);
    }

}
