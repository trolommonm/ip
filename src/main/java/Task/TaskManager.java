package Task;

import Common.CommonFunctions;
import Storage.Storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> taskList = new ArrayList<Task>();
    private Storage storage = new Storage();

    public TaskManager() {
        try {
            taskList = storage.retrieveTasks();
        } catch (FileNotFoundException e) {
            CommonFunctions.printMessage(e.getMessage());
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
        CommonFunctions.printDivider();
        CommonFunctions.printWithIndentation("Got it. I've added this task:");
        CommonFunctions.printWithIndentation(task.toString());
        CommonFunctions.printWithIndentation("Now you have " + getNumberOfTasks() + " tasks in the list.");
        CommonFunctions.printDivider();

        try {
            storage.saveTaskListToFile(taskList);
        } catch (IOException e) {
            CommonFunctions.printMessage(e.getMessage());
        }
    }

    public void deleteTask(int indexOfTask) {
        try {
            Task removedTask = taskList.remove(indexOfTask);

            CommonFunctions.printDivider();
            CommonFunctions.printWithIndentation("Noted. I've removed this task:");
            CommonFunctions.printWithIndentation(removedTask.toString());
            CommonFunctions.printWithIndentation("Now you have " + getNumberOfTasks() + " in the list.");
            CommonFunctions.printDivider();
        } catch (IndexOutOfBoundsException e) {
            CommonFunctions.printMessage("Index out of bounds!");
        }
    }

    public void markTaskAsDone(int indexOfTask) {
        try {
            Task task = taskList.get(indexOfTask);
            task.markAsDone();
            CommonFunctions.printMessage("Nice! I've marked this task as done:\n\t" + task.toString());

            storage.saveTaskListToFile(taskList);
        } catch (IndexOutOfBoundsException e) {
            CommonFunctions.printMessage("Index out of bounds!");
        } catch (IOException e) {
            CommonFunctions.printMessage(e.getMessage());
        }
    }

    public void printTasks() {
        CommonFunctions.printDivider();
        for (int i = 0; i < getNumberOfTasks(); i++) {
            CommonFunctions.printWithIndentation((i + 1) + ". " + taskList.get(i));
        }
        CommonFunctions.printDivider();
    }

    public void printIntroduction() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
        CommonFunctions.printMessage("Hello! I'm Duke\n" + "\tWhat can I do for you?");
    }

    public void printGoodBye() {
        CommonFunctions.printMessage("Bye. Hope to see you again soon!");
    }
}
