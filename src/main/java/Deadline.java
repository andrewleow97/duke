import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Deadline class that includes:
 * String description: description of deadline
 * String by: input of do by date/time
 * Date date: formatted Date of 'String by'
 */
public class Deadline extends Task {

    protected String by;
    protected Date date;

    /**
     * Creates deadline Task from user input description and do-by date/time
     * @param description Description of task
     * @param by Do-by date/time that the user inputs
     * @throws ParseException If the user input is not formatted in the correct dd/mm/yyyy hhmm format, throw ParseException, and re-request user for proper input
     */
    public Deadline(String description, String by) throws ParseException {
        super(description);
        this.by = by;
        date = new SimpleDateFormat("dd/MM/yyyy HHmm").parse(by);
    }

    /**
     * Formats deadline task details for storage purposes
     * @return Returns the formatted string
     */
    @Override
    public String writeToFile(){
        return "D | " + getDoneInt() + " | " + this.description + " | " + this.by + "\n";
    }

    /**
     * Formats deadline task details for UI printing purposes
     * @return Returns the formatted string
     */
    @Override
    public String toString() {
        return "[D]" + super.getStatusIcon() + this.description + " (by: " + this.date  + ")";
    }
}