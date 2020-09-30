package Command;

/**
 * Used to represent the delete command input by the user
 */
public class DeleteCommand extends Command {
    private int indexOfTask;

    public DeleteCommand(int indexOfTask) {
        this.indexOfTask = indexOfTask;
    }

    /**
     * Returns the index of the task to be deleted
     * @return Index of the task to be deleted
     */
    public int getIndexOfTask() {
        return indexOfTask;
    }
}
