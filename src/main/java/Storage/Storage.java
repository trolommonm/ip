package Storage;

import Common.CommonFunctions;
import Task.Task;
import Task.Todo;
import Task.Event;
import Task.Deadline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private File dukeFile;

    public Storage() {
        createDataFolder();
        createDukeFile();
    }

    private void createDataFolder() {
        File dataFolder = new File("data");
        if (!dataFolder.isDirectory()) {
            try {
                dataFolder.mkdir();
            } catch (SecurityException e) {
                CommonFunctions.printMessage(e.getMessage());
            }
        }
    }

    private void createDukeFile() {
        File dukeFile = new File("data/Duke.txt");
        if (!dukeFile.exists()) {
            try {
                dukeFile.createNewFile();
            } catch (SecurityException e) {
                CommonFunctions.printMessage(e.getMessage());
            } catch (IOException e) {
                CommonFunctions.printMessage(e.getMessage());
            }
        }

        this.dukeFile = dukeFile;
    }

    public void saveTaskListToFile(ArrayList<Task> taskList) throws IOException {
        FileWriter fw = new FileWriter(dukeFile);
        for (Task task: taskList) {
            String textForTask = "";
            int isDone = task.getIsDone() ? 1 : 0;
            String description = task.getDescription();

            if (task instanceof Todo) {
                textForTask = "T|" + isDone + "|" + description + "\n";
            } else if (task instanceof Event) {
                Event event = (Event)task;
                textForTask = "E|" + isDone + "|" + description + "|" + event.getAt() + "\n";
            } else if (task instanceof Deadline) {
                Deadline deadline = (Deadline)task;
                textForTask = "D|" + isDone + "|" + description + "|" + deadline.getBy() + "\n";
            }

            fw.write(textForTask);
        }

        fw.close();
    }

    public ArrayList<Task> retrieveTasks() throws FileNotFoundException {
        Scanner sc = new Scanner(dukeFile);
        ArrayList<Task> taskList = new ArrayList<Task>();

        while (sc.hasNext()) {
            String[] lineSplit = sc.nextLine().split("\\|");
            Task task;
            switch (lineSplit[0]) {
            case "T":
                task = new Todo(lineSplit[2]);
                break;
            case "E":
                task = new Event(lineSplit[2], lineSplit[3]);
                break;
            case "D":
                task = new Deadline(lineSplit[2], lineSplit[3]);
                break;
            default:
                CommonFunctions.printMessage("Invalid task detected in Duke.txt!");
                return new ArrayList<Task>();
            }

            if (lineSplit[1].equals("1")) {
                task.markAsDone();
            }

            taskList.add(task);
        }

        return taskList;
    }
}
