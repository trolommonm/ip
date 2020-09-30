package Command;

/**
 * Used to represent the event command input by the user
 */
public class EventCommand extends Command {
    private String at;
    private String description;

    public EventCommand(String description, String at) {
        this.description = description;
        this.at = at;
    }

    /**
     * Returns the description of the event task input by the user
     * @return Description of the event task input by the user
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the duration of the event task input by the user
     * @return Duration of the event task input by the user
     */
    public String getAt() {
        return at;
    }
}
