package Command;

/**
 * Represents the done command input the user
 */
public class DoneCommand extends Command {
    private int indexOfTask;

    public DoneCommand(int indexOfTask) {
        this.indexOfTask = indexOfTask;
    }

    /**
     * Returns the index of the task to be marked as done
     * @return Index of the task to be marked as done
     */
    public int getIndexOfTask() {
        return indexOfTask;
    }

}
