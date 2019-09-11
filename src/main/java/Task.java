/**
 * Task class to be inherited, contains the task description, and its completion status
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for the Task class that takes in the task's description, and sets the tasks done status to false by default
     * @param description Description of the task according to the user's input
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Method to mark the task as done by setting the boolean isDone to true (default is false)
     */
    public void markasDone() { // set task as done
        this.isDone = true;
    }

    /**
     * Method to return the task's status as either a tick or cross, according to its isDone variable
     * @return Returns either a tick or cross for printing purposes
     */
    public String getStatusIcon() { // tried copying from website unicode symbols not working
        return (isDone ? "[✓]" : "[✗]"); //return tick or X symbols
    }

    /**
     * Method to return the task's status as an integer value (1 is done, 0 is not done)
     * @return Returns the integer value of the boolean variable isDone
     */
    public int getDoneInt() {
        return (isDone ? 1 : 0);
    }

    /**
     * Formats the Task details for storage purposes
     * @return Returns the formatted string
     */
    public String writeToFile(){
        return "T | " + getDoneInt() + " | " + this.description + "\n";
    }

    /**
     * Formats the Task details for printing purposes
     * @return Returns the formatted string
     */
    @Override
    public String toString() {
        return (this.getStatusIcon() + this.description);
    }
}
