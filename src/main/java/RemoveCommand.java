/**
 * RemoveCommand that inherits the Command class, that removes one task from the tasklist
 */
public class RemoveCommand extends Command {
    private int x;

    /**
     * Constructor that takes in the user's input from the command line, and checks for input validity
     * If input is valid, convert the user's input into an integer to store
     * @param input The user's input in the command line
     * @throws DukeException Thrown when the user's input is not a number, or does not input anything after 'remove '
     */
    public RemoveCommand(String input) throws DukeException{
        try {
            String[] command = input.split(" ");
            if (command[1].isEmpty() || command[1].isBlank() || input.length() <= 5) {
                throw new DukeException("☹ OOPS!!! Please enter a valid number");
            } else {
                this.x = Integer.parseInt(command[1]) - 1;
            }
        } catch (DukeException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Takes the integer stored from the user's input, and checks if its index is within the range of the taskList
     * If so, remove the indexed task from the list, prints the information back to the user, and saves the new task list
     * @param tasks tasklist of task from which to remove the task
     * @param ui ui to handle printing
     * @param storage storage to handle storing the save file
     * @throws DukeException thrown when the input integer is out of bounds of the taskList ArrayList
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (x < 0 || x > tasks.taskList.size()) {
            throw new DukeException("☹ OOPS!!! That task index is not in your task list");
        }
        ui.showMessage("Noted. I've removed this task: ");
        ui.showMessage(tasks.taskList.get(x).toString());
        tasks.taskList.remove(x);
        ui.showMessage("You now have " + tasks.taskList.size() + " tasks in the list.");
        storage.saveFile(tasks.taskList);
    }
}
