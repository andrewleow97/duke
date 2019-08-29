public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String writeToFile(){
        return "T | " + getDoneInt() + " | " + this.description + "\n";
    }

    @Override
    public String toString() {
        return "[T]" + this.getStatusIcon() + this.description;
    }
}
