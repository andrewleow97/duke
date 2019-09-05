import java.util.ArrayList;

public class FindCommand extends Command {
    private String findString;
    public FindCommand (String input) throws DukeException {
        if (input.substring(5).length() <= 1) {
            throw new DukeException("☹ OOPS!!! Please enter an input");
        }
        findString = input.substring(5);
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ArrayList<Task> findArray = new ArrayList<>();
        for (int i = 0; i < tasks.taskList.size(); i++) {
            if (tasks.taskList.get(i).toString().contains(findString)) {
                findArray.add(tasks.taskList.get(i));
            }
        }
        if (findArray.isEmpty()) {
            ui.showError("☹ OOPS!!! No tasks in your task list match your search.");
        }
        for (int i = 1; i <= findArray.size(); i++) {
            ui.showMessage((i+1) + ". " + findArray.get(i).toString());
        }
    }
}
