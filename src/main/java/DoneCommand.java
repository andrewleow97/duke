public class DoneCommand extends Command {
    private int x;
    public DoneCommand (String command) throws DukeException {
            if (command.length() <= 1) {
                throw new DukeException("☹ OOPS!!! Please enter a valid number");
            }
            int x = Integer.parseInt(command) - 1;

    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (x < 1 || x > tasks.taskList.size()) {
            throw new DukeException("☹ OOPS!!! That task is not in your list");
        } else {
            tasks.taskList.get(x).markasDone();
            ui.showIndent();
            ui.showMessage("Nice! I've marked this task as done: ");
            System.out.println(tasks.taskList.get(x).toString());
        }
    }
}
