import java.text.ParseException;

public class Parser {
    public static Command parse(String input) throws DukeException, ParseException {
        String[] command = input.split(" ");
        switch (command[0]) {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "done":
                return new DoneCommand(input);
            case "todo":
                return new ToDoCommand(input);
            case "deadline":
                return new DeadlineCommand(input);
            case "event":
                return new EventCommand(input);
            case "save":
                return new SaveCommand();
            case "remove":
                return new RemoveCommand(input);
            case "find":
                return new FindCommand(input);
            default:
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
