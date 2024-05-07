public class OutputHandler {
    public static void displayPath(String[] path) {
        System.out.print("Path: ");
        for (String word : path) {
            System.out.print(word + " ");
        }
        System.out.println();
    }

    public static void displayVisitedNodes(int count) {
        System.out.println("Number of nodes visited: " + count);
    }

    public static void displayExecutionTime(long time) {
        System.out.println("Program execution time: " + time + " miliseconds\n");
    }
}
