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

import Task.Task;
import Ui.Ui;

import java.util.ArrayList;
import java.util.Arrays;

public class Parser {

    private Ui ui = new Ui();

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

    private TodoCommand handleTodo(String[] inputSplit) throws DukeException {
        String description = String.join(" ",
                Arrays.copyOfRange(inputSplit, 1, inputSplit.length));

        if (description.isEmpty()) {
            throw new DukeException("Please input the description!");
        }

        return new TodoCommand(description);
    }

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

    private FindCommand handleFind(String[] inputSplit) throws DukeException {
        try {
            String keyword = inputSplit[1];
            return new FindCommand(keyword);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please input a keyword to search for!");
        }
    }

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
