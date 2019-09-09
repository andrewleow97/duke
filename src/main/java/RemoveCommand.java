public class RemoveCommand extends Command {
    private int x;
    public RemoveCommand(String command) throws DukeException{
        if (command.length() < 1) {
            throw new DukeException("☹ OOPS!!! Please enter a valid number");
        }
        this.x = Integer.parseInt(command) - 1;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (x < 0 || x > tasks.taskList.size()) {
            throw new DukeException("☹ OOPS!!! That task index is not in your task list");
        }
        ui.showMessage("Noted. I've removed this task: ");
        ui.showMessage(tasks.taskList.get(x).toString());
        tasks.removeFromList(x);
        ui.showMessage("You now have " + tasks.taskList.size() + " tasks in the list.");
        storage.saveFile(tasks.taskList);
    }
}
