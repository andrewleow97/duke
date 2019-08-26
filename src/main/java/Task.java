public class Task {
    protected String description;
    protected boolean isDone;
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    public void markasDone() { // set task as done
        this.isDone = true;
    }
    public String getStatusIcon() { // tried copying from website unicode symbols not working
        return (isDone ? "✓" : "✗"); //return tick or X symbols
    }
    public String getDescription() { // returns description of task
        return this.description;
    }
}
