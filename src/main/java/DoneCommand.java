/**
 * DoneCommand that handles 'done' cases from user input.
 * Inherits Command class
 */
public class DoneCommand extends Command {
    private int x;

    /**
     * Checks if input is valid, and converts it to an int to be stored in the class
     * Throws exceptions is user does not input a valid number
     * @param input User input of a number to be converted into an integer
     */
    public DoneCommand (String input) {
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
     * Sets the isDone of a task to true/1, based on the index of the task in the task list, and the user input
     * After which it saves the tasklist to the save file
     * @param tasks tasklist of tasks, sets the i-th task as done based on user input
     * @param ui ui for printing
     * @param storage storage for saving the task list
     * @throws DukeException if task index is not in the list
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            if (this.x < 0 || this.x >= tasks.taskList.size()) {
                throw new DukeException("☹ OOPS!!! That task index is not in your list");
            } else {
                tasks.taskList.get(x).markasDone();
                ui.showMessage("Nice! I've marked this task as done: ");
                ui.showMessage(tasks.taskList.get(x).toString());
                storage.saveFile(tasks.taskList);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            ui.showError("☹ OOPS!!! Please enter a valid number");
        }
    }
}
