import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasksList = new ArrayList<Task>();

    public ArrayList<Task> getTasksList() {
        return tasksList;
    }

    public int getNumberOfTasks() {
        return tasksList.size();
    }

    public void addTask(Task task) {
        tasksList.add(task);
        CommonFunctions.printDivider();
        CommonFunctions.printWithIndentation("Got it. I've added this task:");
        CommonFunctions.printWithIndentation(task.toString());
        CommonFunctions.printWithIndentation("Now you have " + getNumberOfTasks() + " tasks in the list.");
        CommonFunctions.printDivider();
    }

    public void markTaskAsDone(int indexOfTask) {
        try {
            Task task = tasksList.get(indexOfTask);
            task.markAsDone();
            CommonFunctions.printMessage("Nice! I've marked this task as done:\n\t" + task.toString());
        } catch (IndexOutOfBoundsException e) {
            CommonFunctions.printMessage("Index out of bounds!");
        }
    }

    public void printTasks() {
        CommonFunctions.printDivider();
        for (int i = 0; i < getNumberOfTasks(); i++) {
            CommonFunctions.printWithIndentation((i + 1) + ". " + tasksList.get(i));
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
