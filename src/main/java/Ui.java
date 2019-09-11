import java.util.Scanner;

import static java.lang.System.out;

/**
 * Ui class that handles printing to the user
 */
public class Ui {
    private Scanner scanner;

    /**
     * Constructor for the Ui class, that starts a new scanner to read in user input
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Method to print a line for formatting
     */
    public void showLine() {
        out.println("    ____________________________________________________________");
    }

    /**
     * Method to print an indent for formatting
     */
    public void showIndent() {
        out.print("    ");
    }

    /**
     * Method to print the welcome message when Duke is first run
     */
    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        out.println("Hello from\n" + logo + "\nHow can I help you?\n");
    }

    /**
     * Method to print a formatted message to the user
     * @param e String to be displayed to the user
     */
    public void showMessage(String e) {
        showIndent();
        out.println(e);
    }

    /**
     * Method to print the goodbye message to the user when the ExitCommand is called
     */
    public void showGoodbye() {
        showIndent();
        out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Method to print a formatted error message to the user
     * @param e String to be displayed to the user
     */
    public void showError(String e) {
        showIndent();
        out.println(e);
    }

    /**
     * Method to show a message when the save file cannot be loaded for some reason
     */
    public void showLoadingError() {
        showLine();
        showMessage("Error loading from list of tasks at: src/main/java/data/duke.txt");
        showLine();
    }

    /**
     * Method to read the next line of the users input, called in Duke's run function
     * @return
     */
    public String readCommand() {
        String input = scanner.nextLine();
        return input;
    }
}
