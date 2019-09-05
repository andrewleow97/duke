public class ExitCommand extends Command {
    public void execute (TaskList tasks, Ui ui, Storage storage) {
        super.isExit = true;
        ui.showGoodbye();
        storage.saveFile(tasks.taskList);
    }
}
