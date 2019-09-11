/**
 * SaveCommand class that inherits the Command class called by the parser class when user inputs 'save' and wants to save the current list to their save file
 */
public class SaveCommand extends Command {
    /**
     * Constructor for the SaveCommand class
     */
    public SaveCommand() {
    }

    /**
     * Calls the storage.saveFile method, and prints out a message that the list of tasks is saved
     * @param tasks taskList of tasks to be saved
     * @param ui ui to handle printing
     * @param storage storage to handle storing the save file
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        storage.saveFile(tasks.taskList);
        ui.showMessage("Got it, I've saved your list of tasks.");
    }
}
