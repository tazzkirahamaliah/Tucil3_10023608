import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> dictionary = new HashSet<>();
        dictionary = loadDictionary("words.txt");

        System.out.print("Input start word: ");
        String startWord = scanner.next();
        System.out.print("Input end word: ");
        String endWord = scanner.next();
        System.out.print("Choose algorithm (UCS/GBFS/A*): ");
        String algorithm = scanner.next();
        WordLadderSolver solver = new WordLadderSolver(dictionary);

        switch (algorithm) {
            case "UCS":
                solver.solveUsingUCS(startWord, endWord);
                break;
            case "GBFS":
                solver.solveUsingGreedy(startWord, endWord);
                break;
            case "A*":
                solver.solveUsingAStar(startWord, endWord);
                break;
            default:
                System.out.println("The algorithm entered is invalid.");
                break;
        }
        scanner.close();
    }

    private static Set<String> loadDictionary(String filename) {
        Set<String> dict = new HashSet<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim().toLowerCase();
                dict.add(word);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + " not found.");
        }
        return dict;
    }
}
