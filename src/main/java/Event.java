import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task{
    protected String time;
    protected Date date;
    public Event (String description, String time) throws ParseException {
        super(description);
        this.time = time;
        date = new SimpleDateFormat("dd/MM/yyyy HHmm").parse(time);
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
        return ("[E]" + super.getStatusIcon() + this.description + " (at: " + this.date + ")");
    }
}
