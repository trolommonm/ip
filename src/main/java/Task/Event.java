package Task;

/**
 * Used to represent an Event task
 */
public class Event extends Task {
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Return the duration of the event object
     * @return Duration of the event object
     */
    public String getAt() {
        return at;
    }

    /**
     * Returns the String representation of the event object
     * @return String representation of the event object
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
