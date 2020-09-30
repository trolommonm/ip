package Command;

public class EventCommand extends Command {
    private String at;
    private String description;

    public EventCommand(String description, String at) {
        this.description = description;
        this.at = at;
    }

    public String getDescription() {
        return description;
    }

    public String getAt() {
        return at;
    }
}
