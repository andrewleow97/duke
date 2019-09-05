public class ToDoCommand extends Command {
    private String description;
    public ToDoCommand(String input) throws DukeException{
        if (input.substring(4).length() <= 1) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        } else {
            this.description = input.substring(5);
        }
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (this.description.isEmpty()) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }
        ToDo tempToDo = new ToDo(this.description);
        tasks.taskList.add(tempToDo);
        ui.showLine();
        ui.showIndent();
        ui.showMessage("Got it, I've added this task: " );
        ui.showIndent();
        ui.showMessage(tempToDo.toString());
        ui.showIndent();
        ui.showMessage("You now have " + tasks.taskList.size() + " tasks in the list.");
    }
}
