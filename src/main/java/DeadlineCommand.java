import java.text.ParseException;

/**
 * Deadline Command that handles when user wants to add a deadline task to the tasklist, extends the abstract Command class
 */
public class DeadlineCommand extends Command {
    protected String description;
    protected String by;

    /**
     * Instantiates DeadlineCommand from the Parser class, taking the users input
     * @param input Entire string input by the user of the format (deadline 'description' /by 'by')
     * @throws DukeException Handles bad formatting of the user input
     * @throws ParseException Handles bad date format of user input
     */
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

    /**
     * Adds the deadline task to the tasklist, prints confirmation through the ui as well as number of tasks in the list, and stores the newly added deadline task to the storage file
     * Throws ParseException and ArrayIndexOutOfBoundsException if input is formatted incorrectly
     * @param tasks tasklist of tasks that the new deadline task is added to
     * @param ui Ui that handles printing of messages
     * @param storage Storage to store the tasklist
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
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
