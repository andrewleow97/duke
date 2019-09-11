import java.util.ArrayList;

/**
 * TaskList class to contain the tasklist that Duke uses to store tasks
 */
public class TaskList {
    public ArrayList<Task> taskList = new ArrayList<Task>(100);

    /**
     * Constructor for the TaskList class that creates a new ArrayList of Tasks at initial capacity of 100
     */
    public TaskList() {
        this.taskList = new ArrayList<Task>(100);
    }

    /**
     * Constructor for the TaskList class that copies an existing ArrayList of Tasks to its own taskList
     * @param List An existing ArrayList of Tasks read from storage to be copied into TaskList
     */
    public TaskList(ArrayList<Task> List) {
        taskList.addAll(List);
    }
}
