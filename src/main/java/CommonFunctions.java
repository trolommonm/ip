public class CommonFunctions {
    private static final String dividerLine = "____________________________________________________________";

    public static void printMessage(String message) {
        printWithIndentation(dividerLine);
        printWithIndentation(message);
        printWithIndentation(dividerLine);
    }

    public static void printWithIndentation(String string) {
        System.out.println("\t" + string);
    }

    public static void printDivider() {
        printWithIndentation(dividerLine);
    }
}
