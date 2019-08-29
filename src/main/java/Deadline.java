public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    @Override
    public String writeToFile(){
        return "D | " + getDoneInt() + " | " + this.description + " | " + this.by + "\n";
    }

    @Override
    public String toString() {
        return "[D]" + super.getStatusIcon() + this.description + " (by: " + this.by + ")";
    }
}