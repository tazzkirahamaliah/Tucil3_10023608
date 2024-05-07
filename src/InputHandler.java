import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static String getInput(String message) {
        System.out.print(message + ": ");
        return scanner.next();
    }
}
