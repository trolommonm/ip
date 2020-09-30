package Command;

public class DoneCommand extends Command {
    private int indexOfTask;

    public DoneCommand(int indexOfTask) {
        this.indexOfTask = indexOfTask;
    }

    public int getIndexOfTask() {
        return indexOfTask;
    }

}
