import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {

    protected String by;
    protected Date date;
    public Deadline(String description, String by) throws ParseException {
        super(description);
        this.by = by;
        date = new SimpleDateFormat("dd/MM/yyyy HHmm").parse(by);
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
        return "[D]" + super.getStatusIcon() + this.description + " (by: " + this.date  + ")";
    }
}