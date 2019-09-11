import java.util.ArrayList;

/**
 * FindCommand that inherits command, that searches the tasklist for tasks with similar words as the user input
 */
public class FindCommand extends Command {
    private String findString;

    /**
     * Constructor that checks for the input length, and if it is valid save the input as the string to be found
     * @param input The input that the user types into the command line
     * @throws DukeException Thrown if the user does not add any input after 'find '
     */
    public FindCommand (String input) throws DukeException {
        if (input.substring(5).length() <= 1) {
            throw new DukeException("☹ OOPS!!! Please enter an input");
        }
        findString = input.substring(5);
    }

    /**
     * Searches the taskList for the user's input, and stores it in a separate array to be printed
     * @param tasks tasklist of tasks to be searched for the user's input
     * @param ui ui to handle printing of messages and errors
     * @param storage storage to handle storing the task list
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> findArray = new ArrayList<>();
        for (int i = 0; i < tasks.taskList.size(); i++) {
            if (tasks.taskList.get(i).toString().contains(findString)) {
                findArray.add(tasks.taskList.get(i)); // add to findArray any tasks that contain the user's input in its toString() string
            }
        }
        if (findArray.isEmpty()) { // if list is empty, show error to user
            ui.showError("☹ OOPS!!! No tasks in your task list match your search.");
        }
        for (int i = 1; i <= findArray.size(); i++) { // otherwise, print the list of tasks found
            ui.showMessage((i+1) + ". " + findArray.get(i).toString());
        }
    }
}
