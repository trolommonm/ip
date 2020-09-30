package Task;

/**
 * Used to represent a Deadline task
 */
public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the deadline of this deadline object
     * @return Deadline of this deadline object
     */
    public String getBy() {
        return by;
    }

    /**
     * Override the String representation of deadline object
     * @return String representation of deadline object
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
