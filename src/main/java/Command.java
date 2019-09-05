public abstract class Command {

    protected boolean isExit = false;
    public Command() {
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
    }

    public boolean isExit() {
        return this.isExit;
    }
}
