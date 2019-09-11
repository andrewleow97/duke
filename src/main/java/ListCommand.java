/**
 * ListCommand that inherits the Command class, used by the Parser class when the user inputs 'list'
 */
public class ListCommand extends Command {

    /**
     * Prints the list of tasks (taskList in TaskList class) in order for the user to see
     * Shows the task type, whether task is done, the description of the task and its do-by date if applicable
     * @param tasks tasklist of tasks to be listed and printed
     * @param ui ui to handle printing
     * @param storage storage to handle storing the task list
     * @throws DukeException
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            if (tasks.taskList.isEmpty()) { // throw error if task list is empty
                throw new DukeException("☹ OOPS!!! Your list of tasks is empty.");
            }
            ui.showMessage("Here are the tasks in you list: ");
            for (int i = 0; i < tasks.taskList.size(); i++) { // prints all tasks in tasklist formatted by order of index and its toString()
                ui.showMessage(i + 1 + ". " + tasks.taskList.get(i).toString());
            }
        } catch (DukeException e) {
            ui.showError(e.getMessage());
        }
    }
}
