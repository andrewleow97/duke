import java.text.ParseException;

/**
 * Event Command that handles when user wants to add a Event task to the tasklist, extends the abstract Command class
 */
public class EventCommand extends Command{
    protected String description;
    protected String by;

    /**
     * Instantiates EventCommand from the Parser class, taking the users input
     * @param input Entire string input by the user of the format (Event 'description' /at 'time')
     * @throws DukeException Handles bad formatting of the user input
     * @throws ParseException Handles bad date format of user input
     */
    public EventCommand(String input) throws DukeException, ParseException {
        try {
            if (!input.substring(5).contains("/at")) {
                throw new DukeException("☹ OOPS!!! Please input the correct format: event (description) /at (time)");
            }
            String[] eventArray = input.split("/at");
            if ((input.substring(5).length() <= 1) || (eventArray[0].substring(5).isBlank())) {
                throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
            }
            if (eventArray[1].length() <= 1) {
                throw new DukeException("☹ OOPS!!! The time of a event cannot be empty.");
            }
            this.description = eventArray[0].substring(5);
            this.by = eventArray[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("☹ OOPS!!! The time of a event cannot be empty.");
        }
    }

    /**
     * Adds the Event task to the tasklist, prints confirmation through the ui as well as number of tasks in the list, and stores the newly added Event task to the storage file
     * Throws ParseException and ArrayIndexOutOfBoundsException if input is formatted incorrectly
     * @param tasks tasklist of tasks that the new Event task is added to
     * @param ui Ui that handles printing of messages
     * @param storage Storage to store the tasklist
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (this.description.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
        }
        if (this.by.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The time of a event cannot be empty.");
        }
        try {
            Event tempEvent = new Event(this.description, this.by);
            tasks.taskList.add(tempEvent);
            ui.showMessage("Got it, I've added this task: ");
            ui.showMessage(tempEvent.toString());
            ui.showMessage("You now have " + tasks.taskList.size() + " tasks in the list.");
            storage.saveFile(tasks.taskList);
        } catch (ParseException e) {
            ui.showError("☹ OOPS!!! Please enter a correct date format (dd/mm/yyyy HHmm)");
        }
    }
}
