package Command;

public class DeleteCommand extends Command {
    private int indexOfTask;

    public DeleteCommand(int indexOfTask) {
        this.indexOfTask = indexOfTask;
    }

    public int getIndexOfTask() {
        return indexOfTask;
    }
}
