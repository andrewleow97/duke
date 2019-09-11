import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Storage class to handle reading and writing to the save file at a predefined filePath
 */
public class Storage {
    private File file;

    /**
     * Constructor for the Storage class
     * @param filePath filePath of the save file to be read/written to
     */
    public Storage(String filePath) {
        this.file = new File(filePath);
    }

    /**
     * Scans the save file line by line, and stores its content in an ArrayList of tasks according to the data read
     * @return Returns an ArrayList of tasks to be used by Duke
     * @throws FileNotFoundException Handles if there is no file found at the filePath
     * @throws ParseException thrown if there are errors in the save file's content
     */
    public ArrayList<Task> loadFile() throws FileNotFoundException, ParseException {
            Scanner fileScan = new Scanner(file);
            ArrayList<Task> fileList = new ArrayList<>();
            while (fileScan.hasNextLine()) {
                String temp = fileScan.nextLine();
                String[] tempArray = temp.split(" \\| ", 4);
                Task t = null;
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
                }
                if (tempArray[1].contains("1")) {
                    t.markasDone();
                }
                fileList.add(t);
            }
            return fileList;
    }

    /**
     * Method to save the task list in Duke to the specified filePath
     * @param taskList Takes in the taskList of tasks, and saves to the save file task by task
     */
    public void saveFile(ArrayList<Task> taskList) {
        Ui ui = new Ui();
        try {
            FileWriter fileWriter = new FileWriter("src/main/java/data/duke.txt");
            String save = "";
            for (Task t: taskList) {
                save += t.writeToFile();
            }
            fileWriter.write(save);
            fileWriter.close();
        } catch (IOException e) { // required for fileWriter to not throw errors
        }
    }
}
