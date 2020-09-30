package Task;

import Ui.Ui;
import Storage.Storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> taskList;
    private Storage storage = new Storage();
    private Ui ui = new Ui();

    public TaskManager() {
        try {
            taskList = storage.retrieveTasks();
        } catch (FileNotFoundException e) {
            taskList = new ArrayList<Task>();
            ui.printMessageWithDivider(e.getMessage());
        }
    }

    public ArrayList<Task> getTasksList() {
        return taskList;
    }

    public int getNumberOfTasks() {
        return taskList.size();
    }

    public void addTask(Task task) {
        taskList.add(task);

        ui.printMessageWithDivider("Got it. I've added this task:",
                task.toString(),
                "Now you have " + getNumberOfTasks() + " tasks in the list.");

        try {
            storage.saveTaskListToFile(taskList);
        } catch (IOException e) {
            ui.printMessageWithDivider(e.getMessage());
        }
    }

    public void deleteTask(int indexOfTask) {
        try {
            Task removedTask = taskList.remove(indexOfTask);

            ui.printMessageWithDivider("Noted. I've removed this task:",
                    removedTask.toString(),
                    "Now you have " + getNumberOfTasks() + " in the list.");

            storage.saveTaskListToFile(taskList);
        } catch (IndexOutOfBoundsException e) {
            ui.printMessageWithDivider("Index out of bounds!");
        } catch (IOException e) {
            ui.printMessageWithDivider(e.getMessage());
        }
    }

    public void markTaskAsDone(int indexOfTask) {
        try {
            Task task = taskList.get(indexOfTask);
            task.markAsDone();
            ui.printMessageWithDivider("Nice! I've marked this task as done:", task.toString());

            storage.saveTaskListToFile(taskList);
        } catch (IndexOutOfBoundsException e) {
            ui.printMessageWithDivider("Index out of bounds!");
        } catch (IOException e) {
            ui.printMessageWithDivider(e.getMessage());
        }
    }

    public void printTasks() {
        ui.printTasks(getTasksList());
    }
}
