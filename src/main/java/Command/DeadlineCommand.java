package Command;

public class DeadlineCommand extends Command {
    private String by;
    private String description;

    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    public String getDescription() {
        return description;
    }

    public String getBy() {
        return by;
    }

}
