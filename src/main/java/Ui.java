import java.util.Scanner;

import static java.lang.System.out;

public class Ui {
    private Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public void showLine() {
        out.println("    ____________________________________________________________");
    }

    public void showIndent() {
        out.print("    ");
    }

    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        out.println("Hello from\n" + logo + "\nHow can I help you?\n");
    }

    public void showMessage(String e) {
        showIndent();
        out.println(e);
    }

    public void showGoodbye() {
        showIndent();
        out.println("Bye. Hope to see you again soon!");
    }

    public void showError(String e) {
        showIndent();
        out.println(e);
    }

    public void showLoadingError() {
        out.println("Error loading from list of tasks at: src/main/java/data/duke.txt");
    }

    public String readCommand() {
        String input = scanner.nextLine();
        return input;
    }
}
