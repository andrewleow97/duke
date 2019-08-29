public class Event extends Task {
    protected String time;
    public Event (String description, String time){
        super(description);
        this.time = time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String writeToFile(){
        return "E | " + getDoneInt() + " | " + this.description + " | " + this.time + "\n";
    }

    @Override
    public String toString() {
        return ("[E]" + super.getStatusIcon() + this.description + " (at: " + this.time + ")");
    }
}
