import java.util.Scanner;

import static java.lang.System.out;

public class Duke {
    private static void printIndent() {
        out.print("    ");
    }
    private static void printIndentLine() {
        out.println("    ____________________________________________________________");
    }
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        out.println("Hello from\n" + logo);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                printIndentLine();
                printIndent();
                out.println("Bye. Hope to see you again soon!");
                printIndentLine();
                break;
            } else {
                printIndentLine();
                printIndent();
                out.println(input);
                printIndentLine();
            }
        }
    }
}
