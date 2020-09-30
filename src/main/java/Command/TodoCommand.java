package Command;

/**
 * Used to represent the todo command input by the user
 */
public class TodoCommand extends Command {
    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    /**
     * Returns the description of the todo task input by the user
     * @return Description of the todo task input by the user
     */
    public String getDescription() {
        return description;
    }
}
