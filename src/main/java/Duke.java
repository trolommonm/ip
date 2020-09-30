import Command.Command;
import Command.DoneCommand;
import Command.ListCommand;
import Command.TodoCommand;
import Command.ByeCommand;
import Command.DeadlineCommand;
import Command.EventCommand;
import Command.DeleteCommand;
import Command.FindCommand;

import Ui.Ui;

import Parser.Parser;

import Task.Deadline;
import Task.Event;
import Task.TaskManager;
import Task.Todo;

import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        // initializations
        TaskManager taskManager = new TaskManager();
        Parser parser = new Parser();
        Ui ui = new Ui();
        Scanner sc = new Scanner(System.in);

        ui.printIntroduction();

        Command command = new Command();
        String input;

        while (true) {
            input = sc.nextLine();
            command = parser.parseCommand(input);

            if (command instanceof ListCommand) {
                ui.printTasks(taskManager.getTasksList());
            } else if (command instanceof ByeCommand) {
                ui.printGoodBye();
                break;
            } else if (command instanceof DoneCommand) {
                DoneCommand doneCommand = (DoneCommand)command;
                taskManager.markTaskAsDone(doneCommand.getIndexOfTask());
            } else if (command instanceof TodoCommand) {
                TodoCommand todoCommand = (TodoCommand)command;
                Todo todoTask = new Todo(todoCommand.getDescription());
                taskManager.addTask(todoTask);
            } else if (command instanceof DeadlineCommand) {
                DeadlineCommand deadlineCommand = (DeadlineCommand)command;
                Deadline deadlineTask = new Deadline(deadlineCommand.getDescription(), deadlineCommand.getBy());
                taskManager.addTask(deadlineTask);
            } else if (command instanceof EventCommand) {
                EventCommand eventCommand = (EventCommand)command;
                Event eventTask = new Event(eventCommand.getDescription(), eventCommand.getAt());
                taskManager.addTask(eventTask);
            } else if (command instanceof DeleteCommand) {
                DeleteCommand deleteCommand = (DeleteCommand)command;
                taskManager.deleteTask(deleteCommand.getIndexOfTask());
            } else if (command instanceof FindCommand) {
                FindCommand findCommand = (FindCommand)command;
                taskManager.findAndPrintFilteredTasks(findCommand.getKeyword());
            }

        }
    }
}
