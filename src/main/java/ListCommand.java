public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            if (tasks.taskList.isEmpty()) {
                throw new DukeException("☹ OOPS!!! Your list of tasks is empty.");
            }
            ui.showMessage("Here are the tasks in you list: ");
            for (int i = 0; i < tasks.taskList.size(); i++) {
                ui.showIndent();
                System.out.println(i + 1 + ". " + tasks.taskList.get(i).toString());
            }
        } catch (DukeException e) {
            ui.showError(e.getMessage());
        }
    }
}
