import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * * Event class that includes:
 *  * String description: description of Event
 *  * String time: input of event date/time
 *  * Date date: formatted Date of 'String time'
 */
public class Event extends Task{
    protected String time;
    protected Date date;

    /**
     * * Creates Event Task from user input description and do-by date/time
     * @param description Description of task
     * @param time Date/time that the user inputs
     * @throws ParseException If the user input is not formatted in the correct dd/mm/yyyy hhmm format, throw ParseException, and re-request user for proper input
     */
    public Event (String description, String time) throws ParseException {
        super(description);
        this.time = time;
        date = new SimpleDateFormat("dd/MM/yyyy HHmm").parse(time);
    }

    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Formats event task details for storage purposes
     * @return Returns the formatted string
     */
    @Override
    public String writeToFile(){
        return "E | " + getDoneInt() + " | " + this.description + " | " + this.time + "\n";
    }

    /**
     * Formats event task details for UI printing purposes
     * @return Returns the formatted string
     */
    @Override
    public String toString() {
        return ("[E]" + super.getStatusIcon() + this.description + " (at: " + this.date + ")");
    }
}
