public class Parser {
    public static Command parse(String input) throws DukeException {
        String[] command = input.split(" ");
        switch (command[0]) {
            if (command[1].isEmpty() || command[1].isBlank()) {
                throw new DukeException("☹ OOPS!!! Please enter a valid command");
            }
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "done":
                return new DoneCommand(command[1]);
            case "todo":
                return new ToDoCommand(input);
            case "deadline":
                return new DeadlineCommand(input);
            case "event":
                return new EventCommand(input);
            case "save":
                return new SaveCommand();
            case "remove":
                return new RemoveCommand(command[1]);
            case "find":
                return new FindCommand(input);
            default:
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
