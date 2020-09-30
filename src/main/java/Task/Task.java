package Task;

/**
 * The base class for all kinds of tasks
 */
public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the tick or X symbols
     * @return Unicode for the tick or X symbols
     */
    public String getStatusIcon() {
        // return tick or X symbols
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Mark task as done
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     *
     * @return
     */
    public boolean getIsDone() {
        return isDone;
    }

    /**
     * Returns description of the task
     * @return Description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Override the String representation of task object
     * @return String representation of task object
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
