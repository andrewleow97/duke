import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Duke {
    final static ArrayList<Task> taskList = new ArrayList<Task>(100); // initialize tasklist
    private static void printIndent() {
        out.print("    ");
    } // print the indentation

    private static void printILine() { // print the indented line
        out.println("    ____________________________________________________________");
    }

    public static void addToList(String input) { // add Task class to the taskList ArrayList
        Task temp = new Task(input);
        temp.description = input;
        taskList.add(temp);
    }

    public static void printTask(int i) { // print a single task at index i, including completion status
        printIndent();
        out.print(i+1 + ". ");
        out.print("[" + taskList.get(i).getStatusIcon() + "]");
        out.println(taskList.get(i).getDescription());
    }

    public static void printList() { // print the list of tasks
        printIndent();
        out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {  printTask(i);
        }
    }

    public static void printDone(String index) { // marks task as done, and prints the task symbol
        int i = Integer.parseInt(index) - 1;
        printIndent();
        out.println("Nice! I've marked this task as done: ");
        taskList.get(i).markasDone();
        printTask(i);
    }
    public static void main(String[] args) {
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
            String[] command = input.split(" "); // split up input by spaces
            switch (command[0]) {
                case "bye": // handles case bye, which sets run to false to exit loop
                    printILine();
                    printIndent();
                    out.println("Bye. Hope to see you again soon!");
                    printILine();
                    run = false; // set run to false in order to break the loop
                    break;
                case "list": // print the list of tasks
                    printILine();
                    printList();
                    printILine();
                    break;
                case "done":
                    printILine();
                    printDone(command[1]);
                    printILine();
                    break;
                default: // default add any non list/bye words as tasks
                    printILine();
                    printIndent();
                    out.println("added: " + input);
                    printILine();
                    addToList(input);
            }
        }
    }
}

