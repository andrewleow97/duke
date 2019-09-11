import java.text.ParseException;

/**
 * Parser class that returns the Command to be used according to the first word of the user's input
 */
public class Parser {

    /**
     * parse method that returns a specific command according tothe first word of the user's input
     * @param ui ui to handle printing
     * @param input input of the user in the command line
     * @return Returns a Command according to the user's input
     * @throws DukeException thrown by default if the user's input does not match one of the cases
     * @throws ParseException thrown if the user's input is not of a valid format
     */
    public static Command parse(Ui ui, String input) throws DukeException, ParseException {
        try {
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
        } catch (ArrayIndexOutOfBoundsException | ParseException | NumberFormatException e) {
            ui.showError("☹ OOPS!!! Please enter a valid input");
        }
        return new BlankCommand(); // default case for error handling
    }
}
