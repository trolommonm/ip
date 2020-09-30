package Command;

public class TodoCommand extends Command {
    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
