import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Duke {
    final static ArrayList<Task> taskList = new ArrayList<Task>(100); // initialize taskList
    private static void printIndent() {
        out.print("    ");
    } // print the indentation

    private static void printILine() { // print the indented line
        out.println("    ____________________________________________________________");
    }

    public static void addToList(Task input) { // add Task class to the taskList ArrayList
        taskList.add(input);
    }

    public static void removeTask(int i) { // removing task from taskList
        try {
            if (i-1 >= taskList.size()) {
                throw new DukeException("☹ OOPS!!! That task is not in your list");
            }
            taskList.remove(i - 1);
            out.println("Got it, I've removed that task for you!");
        } catch (DukeException e) {
            out.println(e.getMessage());
        }
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
        }
    }

    public static void printDone(String index) { // marks task as done, and prints the task symbol
        try {
            int i = Integer.parseInt(index) - 1;
            if (i >= taskList.size()) {
                throw new DukeException("☹ OOPS!!! That task is not in your list");
            }
            printIndent();
            out.println("Nice! I've marked this task as done: ");
            taskList.get(i).markasDone();
            printTask(i);
        } catch (DukeException e) {
            printIndent();
            out.println(e.getMessage());
        }
    }

    public static void handleTodo(String input) {
        ToDo tempToDo = new ToDo(input);
        addToList(tempToDo);
        printIndent();
        out.println("Got it. I've added this task: ");
        printTask(taskList.indexOf(tempToDo));
        printIndent();
        out.println("You now have " + taskList.size() + " tasks in the list.");
    } // handle to do case, and print that its added

    public static void handleDeadline (String description, String time) {
        try {
            Deadline tempDeadline = new Deadline(description.substring(9), time);
            addToList(tempDeadline);
            printIndent();
            out.println("Got it. I've added this task: ");
            printIndent();
            out.println(taskList.get(taskList.indexOf(tempDeadline)).toString());
            printIndent();
            out.println("You now have " + taskList.size() + " tasks in the list.");
        } catch (ParseException e) {
            //printILine();
            printIndent();
            out.println("☹ OOPS!!! Please enter a correct date format (dd/mm/yyyy HHmm)");
            //printILine();
        }

    }

    public static void handleEvent(String description, String time) {
        try {
            Event tempEvent = new Event(description.substring(6), time);
            addToList(tempEvent);
            printIndent();
            out.println("Got it. I've added this task: ");
            printIndent();
            out.println(taskList.get(taskList.indexOf(tempEvent)).toString());
            printIndent();
            out.println("You now have " + taskList.size() + " tasks in the list.");
        } catch (ParseException e) {
            printIndent();
            out.println("☹ OOPS!!! Please enter a correct date format (dd/mm/yyyy HHmm)");
        }
    }

    public static void readFile() {
        try {
            File file = new File("src/main/java/data/duke.txt");
            Scanner fileScan = new Scanner(file);
            while (fileScan.hasNext()) {
                String temp = fileScan.nextLine();
                String[] tempArray = temp.split(" \\| ");
                Task t = new Task("");
                switch (tempArray[0]) {
                    case "T":
                        t = new ToDo(tempArray[2]);
                        break;
                    case "D":
                        t = new Deadline(tempArray[2], tempArray[3]);
                        break;
                    case "E":
                        t = new Event(tempArray[2], tempArray[3]);
                        break;
                    default:
                        throw new DukeException("☹ OOPS!!! Invalid task found");
                }
                if (tempArray[1] == "1") {
                    t.markasDone();
                }
                addToList(t);
                //out.println(t.toString());
            }
        } catch (FileNotFoundException e) {
            printILine();
            printIndent();
            out.println("☹ OOPS!!! There is no save file found, creating one for you @ src/main/java/data/duke.txt");
            //createFile();
            printILine();
        } catch (DukeException e) {
            printILine();
            printIndent();
            out.println(e);
            printILine();
        } catch (ParseException e) {
            printILine();
            printIndent();
            out.println("☹ OOPS!!! Incorrect date format found");
            printILine();
        }
    }

    public static void writeFile() { // https://www.javatpoint.com/java-filewriter-class
        try {
            FileWriter fileWriter = new FileWriter("src/main/java/data/duke.txt");
            String temp = "";
            for (Task x: taskList) {
                temp += x.writeToFile();
            }
            fileWriter.write(temp);
            fileWriter.close();
        } catch (IOException e) {
            out.println("☹ OOPS!!! An error occurred in writing to your save file");
        }
    }

    public static void findTask(String input) {
        ArrayList<Task> findArray = new ArrayList<>();
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).toString().contains(input)) {
                findArray.add(taskList.get(i));
          //  } else if (taskList.get(i).) {

            }
        }
        if (findArray.isEmpty()) {
            out.println("☹ OOPS!!! No tasks in your task list match your search.");
            return;
        }
        printIndent();
        out.println("Here are the matching tasks in your list: ");
        for (int i = 0; i < findArray.size(); i++) {
            printIndent();
            out.println((i+1) + ". " + findArray.get(i).toString());
        }
    }

    public static void main(String[] args) throws DukeException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        out.println("Hello from\n" + logo + "\nHow can I help you?\n");
        Scanner scanner = new Scanner(System.in); // initialize scanner to read input
        boolean run = true;
        readFile();
        while (run) { // looping input reading
            String input = scanner.nextLine();
            String[] command = input.split(" "); // split up input by spaces
            switch (command[0]) {
                case "bye": // handles case bye, which sets run to false to exit loop
                    printILine();
                    printIndent();
                    writeFile(); // write to file to save list on exit
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
                    writeFile();
                    break;

                case "todo": // to do
                    try {
                        printILine();
                        if (input.substring(4).length() <= 1) {
                            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                        }
                        handleTodo(input.substring(5));
                        printILine();
                        writeFile();
                        break;
                    }
                    catch (DukeException e) {
                        printIndent();
                        out.println(e.getMessage());
                        printILine();
                    }
                break;

                case "deadline": //deadline
                    try{
                        if (!input.substring(8).contains("/by")) {
                            throw new DukeException("☹ OOPS!!! Please input the correct format: deadline (description) /by (time)");
                        }
                        String[] deadlineArray = input.split("/by");
                        if ((input.substring(8).length() <= 1) || (deadlineArray[0].substring(8).isBlank())) {
                            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                        }
                        if (deadlineArray[1].length() <= 1) {
                            throw new DukeException("☹ OOPS!!! The time of a deadline cannot be empty.");
                        }
                        printILine();
                        handleDeadline(deadlineArray[0], deadlineArray[1]);
                        printILine();
                        writeFile();
                        break;
                    }
                    catch (DukeException e) {
                        printILine();
                        printIndent();
                        out.println(e.getMessage());
                        printILine();
                    }
                break;

                case "event":
                    try {
                        if (!input.substring(5).contains("/at")) {
                            throw new DukeException("☹ OOPS!!! Please input the correct format: event (description) /at (time)");
                        }
                        String[] eventArray = input.split("/at ");
                        if ((input.substring(5).length() <= 1) || eventArray[0].substring(5).isBlank()) {
                            throw new DukeException( "☹ OOPS!!! The description of a event cannot be empty.");
                        }
                        if (eventArray[1].length() <= 1) {
                            throw new DukeException( "☹ OOPS!!! The time of a event cannot be empty.");
                        }
                        printILine();
                        handleEvent(eventArray[0], eventArray[1]);
                        printILine();
                        writeFile();
                        break;
                    }
                    catch (DukeException e) {
                        printILine();
                        printIndent();
                        out.println(e.getMessage());
                        printILine();
                    }
                    break;

                case "save":
                    writeFile();
                    printILine();
                    printIndent();
                    out.println("Got it, I've saved your list of tasks.");
                    printILine();
                break;

                case "remove":
                    try {
                        printILine();
                        printIndent();
                        removeTask((Integer.parseInt(command[1])));
                        printILine();
                        writeFile();
                        break;
                    }  catch (ArrayIndexOutOfBoundsException e) {
                        printILine();
                        printIndent();
                        out.println("☹ OOPS!!! That task index is not in your task list");
                    }
                break;

                case "find":
                    try {
                        printILine();
                        findTask(input.substring(5));
                        printILine();
                        break;
                    } catch (StringIndexOutOfBoundsException e) {
                        printILine();
                        printIndent();
                        out.println("☹ OOPS!!! Please enter an input");
                        printILine();
                    }
                    break;

                default: // default add any non list/bye words as tasks
                    printILine();
                    printIndent();
                    out.println(DukeException.toString("☹ OOPS!!! I'm sorry, but I don't know what that means :-("));
                    printILine();
            }
        }
    }
}

