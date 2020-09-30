package Ui;

import Task.Task;

import java.util.ArrayList;

public class Ui {
    private static final String dividerLine = "____________________________________________________________";

    public void printMessageWithDivider(String... messages) {
        printWithIndentation(dividerLine);
        for (String message: messages) {
            printWithIndentation(message);
        }
        printWithIndentation(dividerLine);
    }

    public void printWithIndentation(String string) {
        System.out.println("\t" + string);
    }

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

    public void printTasks(ArrayList<Task> taskList) {
        printDivider();
        for (int i = 0; i < taskList.size(); i++) {
            printWithIndentation((i + 1) + ". " + taskList.get(i));
        }
        printDivider();
    }
}
