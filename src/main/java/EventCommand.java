import java.text.ParseException;

public class EventCommand extends Command{
    protected String description;
    protected String by;
    public EventCommand(String input) throws DukeException, ParseException {
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
    }
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
            ui.showLine();
            ui.showIndent();
            ui.showMessage("Got it, I've added this task: ");
            ui.showIndent();
            ui.showMessage(tempEvent.toString());
            ui.showIndent();
            ui.showMessage("You now have " + tasks.taskList.size() + " tasks in the list.");
        } catch (ParseException e) {
            ui.showIndent();
            ui.showMessage("☹ OOPS!!! Please enter a correct date format (dd/mm/yyyy HHmm)");
        }
    }
}
