/**
 * To Do class that inherits the Task class to create a To Do task according to the user's input
 */
public class ToDo extends Task {

    /**
     * Constructor for the To Do class that takes in the user's description of the Task
     * @param description The task description according to the user's input
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Formats to do task details for storage purposes
     * @return Returns the formatted string
     */
    @Override
    public String writeToFile(){
        return "T | " + getDoneInt() + " | " + this.description + "\n";
    }

    /**
     * Formats to do task details for printing purposes
     * @return Returns the formatted string
     */
    @Override
    public String toString() {
        return "[T]" + this.getStatusIcon() + this.description;
    }
}
