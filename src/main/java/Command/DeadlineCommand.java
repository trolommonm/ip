package Command;

/**
 * Used to represent the deadline command input by the user
 */
public class DeadlineCommand extends Command {
    private String by;
    private String description;

    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    /**
     * Returns the description of the deadline task input by the user
     * @return Description of the deadline task input by the user
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the deadline of the deadline task input by the user
     * @return Deadline of the deadline task input by the user
     */
    public String getBy() {
        return by;
    }

}
