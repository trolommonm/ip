package Task;

import Ui.Ui;
import Storage.Storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles adding, deleting, finding and marking of tasks as done
 */
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

    /**
     * Returns the lists of tasks currently
     * @return Lists of tasks in type ArrayList<Task>
     */
    public ArrayList<Task> getTasksList() {
        return taskList;
    }

    /**
     * Returns number of tasks in the taskList currently
     * @return Number of tasks in taskList
     */
    public int getNumberOfTasks() {
        return taskList.size();
    }

    /**
     * Adds a task into the taskList
     * @param task Task to be added
     */
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

    /**
     * Removes a task from the taskList
     * @param indexOfTask Index of the task to be removed
     */
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

    /**
     * Finds and prints the tasks with the matching keyword.
     * @param keyword The keyword to be matched
     */
    public void findAndPrintFilteredTasks(String keyword) {
        ArrayList<Task> filteredTaskList = new ArrayList<Task>();
        for (Task t: getTasksList()) {
            if (t.getDescription().contains(keyword)) {
                filteredTaskList.add(t);
            }
        }

        ui.printFilteredTasks(filteredTaskList);
    }

    /**
     * Mark the index of task to be done.
     * @param indexOfTask Index of task to be marked as done.
     */
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

    /**
     * Prints all the tasks in taskList
     */
    public void printTasks() {
        ui.printTasks(getTasksList());
    }
}
