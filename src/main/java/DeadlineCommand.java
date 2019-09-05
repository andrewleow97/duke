import java.text.ParseException;

public class DeadlineCommand extends Command {
    protected String description;
    protected String by;
    public DeadlineCommand(String input) throws DukeException, ParseException {
        try {
        if (!input.substring(8).contains("/by")) {
            throw new DukeException("☹ OOPS!!! Please input the correct format: deadline (description) /by (time)");
        }
        String[] deadlineArray = input.split("/by ");
        if ((input.substring(8).length() <= 1) || (deadlineArray[0].substring(8).isBlank())) {
            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
        }
        if (deadlineArray[1].length() <= 1) {
            throw new DukeException("☹ OOPS!!! The time of a deadline cannot be empty.");
        }
        this.description = deadlineArray[0].substring(9);
        this.by = deadlineArray[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("☹ OOPS!!! The time of a deadline cannot be empty.");
        }
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (this.description.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
        }
        if (this.by.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The time of a deadline cannot be empty.");
        }
        try {
            Deadline tempDeadline = new Deadline(this.description, this.by);
            tasks.taskList.add(tempDeadline);
            ui.showMessage("Got it, I've added this task: ");
            ui.showMessage(tempDeadline.toString());
            ui.showMessage("You now have " + tasks.taskList.size() + " tasks in the list.");
            storage.saveFile(tasks.taskList);
        } catch (ParseException e) {
            ui.showMessage("☹ OOPS!!! Please enter a correct date format (dd/mm/yyyy HHmm)");
        } catch (ArrayIndexOutOfBoundsException e) {
            ui.showMessage("☹ OOPS!!! The time of a deadline cannot be empty.");
        }
    }
}
