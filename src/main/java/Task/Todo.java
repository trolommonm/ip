package Task;

/**
 * Used to represent a Todo task
 */
public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    /**
     * Overrides the String representation of the Todo object
     * @return String representation of the Todo object
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
