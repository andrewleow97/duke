/**
 * ToDoCommand class that inherits the Command class called by the Parser class to handle when the user wants to add a new To Do task
 */
public class ToDoCommand extends Command {
    private String description;

    /**
     * Constructor for the ToDoCommand class that takes in the user's input, and check for a valid description
     * @param input The user's input in the command line
     * @throws DukeException Thrown when there is no description specified by the user
     */
    public ToDoCommand(String input) throws DukeException{
        if (input.substring(4).length() <= 1) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        } else {
            this.description = input.substring(5);
        }
    }

    /**
     * Adds a new To Do task according to the user's input to the tasklist, and prints information to the user. Finally, it will save the taskList to the save file
     * @param tasks taskList of tasks to be added to
     * @param ui ui to handle printing
     * @param storage storage to handle storing the list of tasks to the save file
     * @throws DukeException Thrown when the user does not input a description after 'todo '
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (this.description.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }
        ToDo tempToDo = new ToDo(this.description);
        tasks.taskList.add(tempToDo);
        ui.showMessage("Got it, I've added this task: " );
        ui.showMessage(tempToDo.toString());
        ui.showMessage("You now have " + tasks.taskList.size() + " tasks in the list.");
        storage.saveFile(tasks.taskList);
    }
}
