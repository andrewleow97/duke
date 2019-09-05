import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private File file;

    public Storage(String filePath) {
        this.file = new File(filePath);
        Ui ui = new Ui();
        if (!file.exists()) {
            ui.showError("☹ OOPS!!! There is no save file found, creating one for you @ src/main/java/data/duke.txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                ui.showError("☹ OOPS!!! An error occurred creating your file.");
            }
        }
    }

    public ArrayList<Task> loadFile() {
        try {
            Scanner fileScan = new Scanner(file);
            ArrayList<Task> fileList = new ArrayList<>();
            while (fileScan.hasNextLine()) {
                String temp = fileScan.nextLine();
                String[] tempArray = temp.split(" \\| ");
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
                if (tempArray[1] == "1") {
                    t.markasDone();
                }
                fileList.add(t);
            }
            fileScan.close();
            return fileList;
        } catch (FileNotFoundException e) {
            new Storage("src/main/java/data/duke.txt");
            return null;
        } catch (ParseException e) {
            return null;
        }
    }

    public void saveFile(ArrayList<Task> taskList) {
        Ui ui = new Ui();
        try {
            FileWriter fileWriter = new FileWriter("src/main/java/data/duke.txt");
            String save = null;
            for (Task t: taskList) {
                save += t.writeToFile();
            }
            fileWriter.write(save);
            fileWriter.close();
        } catch (IOException e) {
            ui.showLine();
            ui.showIndent();
            ui.showError("☹ OOPS!!! An error occurred in writing to your save file");
            ui.showLine();
        }
    }
}
