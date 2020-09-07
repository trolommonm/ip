import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    private static TaskManager taskManager = new TaskManager();

    private static void handleDone(String[] inputSplit) throws DukeException {
        try {
            int indexOfTask = Integer.parseInt(inputSplit[1]) - 1;
            taskManager.markTaskAsDone(indexOfTask);
        } catch (NumberFormatException e) {
            throw new DukeException("Invalid index of task!");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please input the index of the task to be marked as done!");
        }
    }

    private static void handleTodo(String[] inputSplit) throws DukeException {
        String description = String.join(" ",
                Arrays.copyOfRange(inputSplit, 1, inputSplit.length));

        if (description.isEmpty()) {
            throw new DukeException("Please input the description!");
        }

        Todo newTodo = new Todo(description);
        taskManager.addTask(newTodo);
    }

    private static void handleDeadline(String[] inputSplit) throws DukeException {
        int indexOfBy = Arrays.asList(inputSplit).indexOf("/by");

        if (indexOfBy == -1) {
            throw new DukeException("Please input the description and/or deadline of the task!");
        }

        String description = String.join(" ", Arrays.copyOfRange(inputSplit, 1, indexOfBy));
        String by = String.join(" ",
                Arrays.copyOfRange(inputSplit, indexOfBy + 1, inputSplit.length));

        if (description.isEmpty() && by.isEmpty()) {
            throw new DukeException("Please input the description and deadline of the task!");
        } else if (description.isEmpty()) {
            throw new DukeException("Please input the description of the task!");
        } else if (by.isEmpty()) {
            throw new DukeException("Please input the deadline of the task!");
        }

        Deadline newDeadline = new Deadline(description, by);
        taskManager.addTask(newDeadline);
    }

    private static void handleEvent(String[] inputSplit) throws DukeException {
        int indexOfAt = Arrays.asList(inputSplit).indexOf("/at");

        if (indexOfAt == -1) {
            throw new DukeException("Please input the description and/or duration of the event!");
        }

        String description = String.join(" ", Arrays.copyOfRange(inputSplit, 1, indexOfAt));
        String at = String.join(" ",
                Arrays.copyOfRange(inputSplit, indexOfAt + 1, inputSplit.length));

        if (description.isEmpty() && at.isEmpty()) {
            throw new DukeException("Please input the description and duration of the event!");
        } else if (description.isEmpty()) {
            throw new DukeException("Please input the description of the event!");
        } else if (at.isEmpty()) {
            throw new DukeException("Please input the duration of the event!");
        }

        Event newEvent = new Event(description, at);
        taskManager.addTask(newEvent);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        taskManager.printIntroduction();

        while (true) {
            String input = sc.nextLine();
            String[] inputSplit = input.split(" ");
            String command = input.trim().toLowerCase().split(" ")[0];

            switch (command) {
            case "list":
                taskManager.printTasks();
                break;
            case "bye":
                taskManager.printGoodBye();
                return;
            case "done":
                try {
                    handleDone(inputSplit);
                } catch (DukeException e) {
                    CommonFunctions.printMessage(e.getMessage());
                }
                break;
            case "todo":
                try {
                    handleTodo(inputSplit);
                } catch (DukeException e) {
                    CommonFunctions.printMessage(e.getMessage());
                }
                break;
            case "deadline":
                try {
                    handleDeadline(inputSplit);
                } catch (DukeException e) {
                    CommonFunctions.printMessage(e.getMessage());
                }
                break;
            case "event":
                try {
                    handleEvent(inputSplit);
                } catch (DukeException e) {
                    CommonFunctions.printMessage(e.getMessage());
                }
                break;
            default:
                CommonFunctions.printMessage("Error command, please try again!");
                break;
            }
        }
    }
}
