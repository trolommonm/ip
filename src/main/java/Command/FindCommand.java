package Command;

/**
 * Used to represent the find command input by the user
 */
public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Returns the keyword to be searched by the user
     * @return Keyword to be searched by the user
     */
    public String getKeyword() {
        return keyword;
    }
}
