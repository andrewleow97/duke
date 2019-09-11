/**
 * ExitCommand that inherits the Command class, called by Parser when the user input is 'bye'
 */
public class ExitCommand extends Command {

    /**
     * Sets isExit boolean to true, which exits the loop in Duke's run() function
     * Also prints the exit message, and saves the tasklist to the save file at filePath
     * @param tasks tasklist
     * @param ui ui for printing
     * @param storage storage for saving the save file
     */
    public void execute (TaskList tasks, Ui ui, Storage storage) {
        super.isExit = true;
        ui.showGoodbye();
        storage.saveFile(tasks.taskList);
    }
}
