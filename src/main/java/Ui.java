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
        showLine();
        showIndent();
        out.println(e);
        showLine();
    }

    public void showGoodbye() {
        showLine();
        showIndent();
        out.println("Bye. Hope to see you again soon!");
        showLine();
    }

    public void showError(String e) {
        showLine();
        showIndent();
        out.println(e);
        showLine();
    }

    public String readCommand() {
        String input = scanner.nextLine();
        return input;
    }
}
