public class SaveCommand extends Command {
    public SaveCommand() {
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        storage.saveFile(tasks.taskList);
        ui.showMessage("Got it, I've saved your list of tasks.");
    }
}
