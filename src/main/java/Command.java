/**
 * Abstract class Command that the Parser class calls, and other specific Commands inherit from
 */
public abstract class Command {

    protected boolean isExit = false;

    public Command() {
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
    }

    /**
     * Returns isExit() value (default is false) to check if input loop should end or not
     * @return boolean isExit value
     */
    public boolean isExit() {
        return this.isExit;
    }
}
