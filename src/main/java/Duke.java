import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        taskManager.printIntroduction();

        inputLoop: while (true) {
            String input = sc.nextLine();
            String[] inputSplit = input.split(" ");
            String command = input.trim().toLowerCase().split(" ")[0];

            switch (command) {
            case "list":
                taskManager.printTasks();
                break;
            case "bye":
                taskManager.printGoodBye();
                break inputLoop;
            case "done":
                try {
                    int indexOfTask = Integer.parseInt(inputSplit[1]) - 1;
                    taskManager.markTaskAsDone(indexOfTask);
                } catch (NumberFormatException e) {
                    CommonFunctions.printMessage("Invalid index of task!");
                } catch (IndexOutOfBoundsException e) {
                    CommonFunctions.printMessage("Please input the index of the task to be marked as done!");
                }
                break;
            case "todo":
                try {
                    String description = String.join(" ",
                            Arrays.copyOfRange(inputSplit, 1, inputSplit.length));
                    Todo newTodo = new Todo(description);
                    taskManager.addTask(newTodo);
                } catch (ArrayIndexOutOfBoundsException e) {
                    CommonFunctions.printMessage("Please input the description!");
                }
                break;
            case "deadline":
                int indexOfBy = Arrays.asList(inputSplit).indexOf("/by");

                if (indexOfBy == -1) {
                    CommonFunctions.printMessage("Please input the deadline of the task!");
                    continue;
                }

                try {
                    String description = String.join(" ",
                            Arrays.copyOfRange(inputSplit, 1, indexOfBy));
                    String by = String.join(" ",
                            Arrays.copyOfRange(inputSplit, indexOfBy + 1, inputSplit.length));
                    Deadline newDeadline = new Deadline(description, by);
                    taskManager.addTask(newDeadline);
                } catch (ArrayIndexOutOfBoundsException e) {
                    CommonFunctions.printMessage("Please input the description and/or deadline of the task!");
                }
                break;
            case "event":
                int indexOfAt = Arrays.asList(inputSplit).indexOf("/at");

                if (indexOfAt == -1) {
                    CommonFunctions.printMessage("Please input the duration of the event!");
                    continue;
                }

                try {
                    String description = String.join(" ",
                            Arrays.copyOfRange(inputSplit, 1, indexOfAt));
                    String at = String.join(" ",
                            Arrays.copyOfRange(inputSplit, indexOfAt + 1, inputSplit.length));
                    Event newEvent = new Event(description, at);
                    taskManager.addTask(newEvent);
                } catch (ArrayIndexOutOfBoundsException e) {
                    CommonFunctions.printMessage("Please input the description and/or duration of the event!");
                }
                break;
            default:
                CommonFunctions.printMessage("Error command, please try again!");
                break;
            }
        }
    }
}
