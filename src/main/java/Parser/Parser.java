package Parser;

import Exception.DukeException;
import Command.Command;
import Command.DoneCommand;
import Command.InvalidCommand;
import Command.ListCommand;
import Command.TodoCommand;
import Command.ByeCommand;
import Command.DeadlineCommand;
import Command.EventCommand;
import Command.DeleteCommand;
import Command.FindCommand;

import Ui.Ui;

import java.util.Arrays;

/**
 * Handles the parsing of the user inputs into the chatbox.
 */
public class Parser {

    private Ui ui = new Ui();

    /**
     * Handles the extracting of the index of tasks specified by the user to be marked as done.
     * @param inputSplit User input that has already been split by an empty space
     * @return DoneCommand object
     * @throws DukeException If an invalid index of task is specified or no index of task specified.
     */
    private DoneCommand handleDone(String[] inputSplit) throws DukeException {
        try {
            int indexOfTask = Integer.parseInt(inputSplit[1]) - 1;
            return new DoneCommand(indexOfTask);
        } catch (NumberFormatException e) {
            throw new DukeException("Invalid index of task!");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please input the index of the task to be marked as done!");
        }
    }

    /**
     * Handles the extraction of the description of the Todo task.
     * @param inputSplit User input that has already been split by an empty space
     * @return TodoCommand object
     * @throws DukeException If no description is input by the user.
     */
    private TodoCommand handleTodo(String[] inputSplit) throws DukeException {
        String description = String.join(" ",
                Arrays.copyOfRange(inputSplit, 1, inputSplit.length));

        if (description.isEmpty()) {
            throw new DukeException("Please input the description!");
        }

        return new TodoCommand(description);
    }

    /**
     * Handles the splitting of the user input to extract the description
     * and the deadline of the Deadline task.
     * @param inputSplit User input that has already been split by an empty space
     * @return DeadlineCommand object
     * @throws DukeException If description and/or deadline of task is not input
     */
    private DeadlineCommand handleDeadline(String[] inputSplit) throws DukeException {
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

        return new DeadlineCommand(description, by);
    }

    /**
     * Handles the splitting of the user input to extract the description
     * and the duration of the Event task.
     * @param inputSplit User input that has already been split by an empty space
     * @return EventCommand object
     * @throws DukeException If description and/or duration of task is not input
     */
    private EventCommand handleEvent(String[] inputSplit) throws DukeException {
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

        return new EventCommand(description, at);
    }

    /**
     * Handles the splitting of the user input to extract the index of task to be deleted.
     * @param inputSplit User input that has already been split by an empty space
     * @return DeleteCommand object
     * @throws DukeException If an invalid index of task is specified or no index of task specified.
     */
    private DeleteCommand handleDelete(String[] inputSplit) throws DukeException {
        try {
            int indexOfTask = Integer.parseInt(inputSplit[1]) - 1;
            return new DeleteCommand(indexOfTask);
        } catch (NumberFormatException e) {
            throw new DukeException("Please input a valid index of task!");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please input the index of task you want to delete!");
        }
    }

    /**
     * Handles the splitting of the user input to extract the keyword to be searched.
     * @param inputSplit User input that has already been split by an empty space
     * @return FindCommand object
     * @throws DukeException If no keyword is specified.
     */
    private FindCommand handleFind(String[] inputSplit) throws DukeException {
        try {
            String keyword = inputSplit[1];
            return new FindCommand(keyword);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please input a keyword to search for!");
        }
    }

    /**
     * Parse the user input
     * @param input User input
     * @return Command Object
     */
    public Command parseCommand(String input) {
        String[] inputSplit = input.split(" ");
        String command = input.trim().toLowerCase().split(" ")[0];

        switch (command) {
        case "list":
            return new ListCommand();
        case "bye":
            return new ByeCommand();
        case "done":
            try {
                return handleDone(inputSplit);
            } catch (DukeException e) {
                ui.printMessageWithDivider(e.getMessage());
                return new InvalidCommand();
            }
        case "todo":
            try {
                return handleTodo(inputSplit);
            } catch (DukeException e) {
                ui.printMessageWithDivider(e.getMessage());
                return new InvalidCommand();
            }
        case "deadline":
            try {
                return handleDeadline(inputSplit);
            } catch (DukeException e) {
                ui.printMessageWithDivider(e.getMessage());
                return new InvalidCommand();
            }
        case "event":
            try {
                return handleEvent(inputSplit);
            } catch (DukeException e) {
                ui.printMessageWithDivider(e.getMessage());
                return new InvalidCommand();
            }
        case "delete":
            try {
                return handleDelete(inputSplit);
            } catch (DukeException e) {
                ui.printMessageWithDivider(e.getMessage());
                return new InvalidCommand();
            }
        case "find":
            try {
                return handleFind(inputSplit);
            } catch (DukeException e) {
                ui.printMessageWithDivider(e.getMessage());
                return new InvalidCommand();
            }
        default:
            ui.printMessageWithDivider("Invalid command, please try again!");
            return new InvalidCommand();
        }
    }

}
