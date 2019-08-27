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

    public static void addToList(Task input) { // add Task class to the taskList ArrayList
        taskList.add(input);
    }

    public static void printTask(int i) { // print a single task at index i, including completion status
        printIndent();
        out.println(taskList.get(i).toString());
    }

    public static void printList() { // print the list of tasks
        printIndent();
        out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            printIndent();
            out.print(i+1 + ". ");
            out.println(taskList.get(i).toString());
            //out.print(taskList.get(i).getStatusIcon());
            //out.println(taskList.get(i).getDescription());
        }
    }

    public static void printDone(String index) { // marks task as done, and prints the task symbol
        int i = Integer.parseInt(index) - 1;
        printIndent();
        out.println("Nice! I've marked this task as done: ");
        taskList.get(i).markasDone();
        printTask(i);
    }

    public static void printTodo(String input) {
        ToDo tempToDo = new ToDo(input);
        addToList(tempToDo);
        printIndent();
        out.println("Got it. I've added this task: ");
        printTask(taskList.indexOf(tempToDo));
        printIndent();
        out.println("You now have " + taskList.size() + " tasks in the list.");
    }

    public static void printDeadline(String description, String time) {
        Deadline tempDeadline = new Deadline(description.substring(9), time);
        addToList(tempDeadline);
        printIndent();
        out.println("Got it. I've added this task: ");
        printIndent();
        out.println(taskList.get(taskList.indexOf(tempDeadline)).toString());
        printIndent();
        out.println("You now have " + taskList.size() + " tasks in the list.");
    }

    public static void printEvent(String description, String time) {
        Event tempEvent = new Event(description.substring(6), time);
        addToList(tempEvent);
        printIndent();
        out.println("Got it. I've added this task: ");
        printIndent();
        out.println(taskList.get(taskList.indexOf(tempEvent)).toString());
        printIndent();
        out.println("You now have " + taskList.size() + " tasks in the list.");
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

                case "done": // done
                    printILine();
                    printDone(command[1]);
                    printILine();
                    break;

                case "todo": // todo
                    printILine();
                    printTodo(input.substring(5));
                    printILine();
                    break;

                case "deadline":
                    printILine();
                    String[] deadlineArray = input.split("/by ");
                    printDeadline(deadlineArray[0], deadlineArray[1]);
                    printILine();
                    break;

                case "event":
                    printILine();
                    String[] eventArray = input.split("/at ");
                    printEvent(eventArray[0], eventArray[1]);
                    printILine();
                    break;
                /*case "print":
                    out.println(command[1]);
                    break;
                */
                default: // default add any non list/bye words as tasks
                    printILine();
                    printIndent();
                    out.println("added: " + input);
                    printILine();
                    Task tempTask = new Task(input);
                    addToList(tempTask);
            }
        }
    }
}

