package Ui;

import Task.Task;

import java.util.ArrayList;

/**
 * Handles the output of messages to the user
 */
public class Ui {
    private static final String dividerLine = "____________________________________________________________";

    /**
     * Prints messages to be displayed to the user, with divider line at the start and end.
     * @param messages Messages that is to be displayed to the user
     */
    public void printMessageWithDivider(String... messages) {
        printWithIndentation(dividerLine);
        for (String message: messages) {
            printWithIndentation(message);
        }
        printWithIndentation(dividerLine);
    }

    /**
     * Prints a message with indentation.
     * @param string The message to be printed
     */
    public void printWithIndentation(String string) {
        System.out.println("\t" + string);
    }

    /**
     * Print the divider line with indentation.
     */
    public void printDivider() {
        printWithIndentation(dividerLine);
    }

    public void printIntroduction() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
        printMessageWithDivider("Hello! I'm Duke", "What can I do for you?");
    }

    public void printGoodBye() {
        printMessageWithDivider("Bye. Hope to see you again soon!");
    }

    /**
     * Prints the lists of tasks currently.
     * @param taskList
     */
    public void printTasks(ArrayList<Task> taskList) {
        printDivider();
        for (int i = 0; i < taskList.size(); i++) {
            printWithIndentation((i + 1) + ". " + taskList.get(i));
        }
        printDivider();
    }

    /**
     * Print the filtered lists of tasks
     * @param taskList
     */
    public void printFilteredTasks(ArrayList<Task> taskList) {
        printDivider();
        printWithIndentation("Here are the matching tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            printWithIndentation((i + 1) + ". " + taskList.get(i));
        }
        printDivider();
    }
}
