import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Duke {
    private static void printIndent() {
        out.print("    ");
    } // print the indentation

    private static void printILine() { // print the indented line
        out.println("    ____________________________________________________________");
    }

    public static void printList(ArrayList<String> taskList) { // print the list of tasks
        for (int i = 0; i < taskList.size(); i++) {
            printIndent();
            out.print(i+1 + ". ");
            out.println(taskList.get(i));
        }
    }
    public static void main(String[] args) {
        ArrayList<String> taskList = new ArrayList<>(100); // initialize tasklist
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        out.println("Hello from\n" + logo);
        Scanner scanner = new Scanner(System.in); // initialize scanner to read input
        boolean run = true;
        while (run) { // looping input reading
            String input = scanner.nextLine();
            switch (input) {
                case "bye": // handles case bye, which sets run to false to exit loop
                    printILine();
                    printIndent();
                    out.println("Bye. Hope to see you again soon!");
                    printILine();
                    run = false;
                    break;
                case "list": // print the list of tasks
                    printILine();
                    printList(taskList);
                    printILine();
                    break;
                default: // default add any non list/bye words as tasks
                    printILine();
                    printIndent();
                    out.println("added: " + input);
                    printILine();
                    taskList.add(input);
            }
        }
    }
}

