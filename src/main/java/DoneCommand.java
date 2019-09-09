public class DoneCommand extends Command {
    private int x;
    public DoneCommand (String input) throws DukeException, ArrayIndexOutOfBoundsException {
        try {
            String[] command = input.split(" ");
            if (command[1].isEmpty() || command[1].isBlank() || input.length() <= 5) {
                throw new DukeException("☹ OOPS!!! Please enter a valid number");
            } else {
                this.x = Integer.parseInt(command[1]) - 1;
            }
        } catch (DukeException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            if (this.x < 0 || this.x >= tasks.taskList.size()) {
                throw new DukeException("☹ OOPS!!! That task is not in your list");
            } else {
                tasks.taskList.get(x).markasDone();
                ui.showMessage("Nice! I've marked this task as done: ");
                ui.showMessage(tasks.taskList.get(x).toString());
                storage.saveFile(tasks.taskList);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            ui.showError("☹ OOPS!!! Please enter a valid number");
        }
    }
}
