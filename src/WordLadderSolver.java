import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class WordLadderSolver {
    private Set<String> dictionary;

    public WordLadderSolver(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public void solveUsingUCS(String startWord, String endWord) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
        Set<String> visited = new HashSet<>();
        int visitedNodes = 0; 
        long startTime = System.currentTimeMillis(); 

        queue.offer(new Node(startWord, null, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            String currentWord = current.getWord();
            visitedNodes++; 
            visited.add(currentWord);

            if (currentWord.equals(endWord)) {
                long executionTime = System.currentTimeMillis() - startTime;
                List<String> path = getPath(current);
                OutputHandler.displayPath(path.toArray(new String[0])); 
                OutputHandler.displayVisitedNodes(visitedNodes); 
                OutputHandler.displayExecutionTime(executionTime); 
                return;
            }

            for (String neighbor : getNeighbors(currentWord)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(new Node(neighbor, current, current.getCost() + 1));
                }
            }
        }

        System.out.println("No solution found.");
    }

    public void solveUsingGreedy(String startWord, String endWord) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getHeuristic));
        Set<String> visited = new HashSet<>();
        int visitedNodes = 0; 
        long startTime = System.currentTimeMillis(); 
        queue.offer(new Node(startWord, null, calculateHeuristic(startWord, endWord)));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            String currentWord = current.getWord();
            visitedNodes++; 
            visited.add(currentWord);

            if (currentWord.equals(endWord)) {
                long executionTime = System.currentTimeMillis() - startTime; 
                List<String> path = getPath(current);
                OutputHandler.displayPath(path.toArray(new String[0])); 
                OutputHandler.displayVisitedNodes(visitedNodes); 
                OutputHandler.displayExecutionTime(executionTime); 
                return;
            }

            for (String neighbor : getNeighbors(currentWord)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(new Node(neighbor, current, calculateHeuristic(neighbor, endWord)));
                }
            }
        }

        System.out.println("No solution found.");
    }

    public void solveUsingAStar(String startWord, String endWord) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getTotalCost));
        Set<String> visited = new HashSet<>();
        int visitedNodes = 0; 
        long startTime = System.currentTimeMillis(); 

        queue.offer(new Node(startWord, null, 0, calculateHeuristic(startWord, endWord)));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            String currentWord = current.getWord();
            visitedNodes++; 
            visited.add(currentWord);

            if (currentWord.equals(endWord)) {
                long executionTime = System.currentTimeMillis() - startTime; 
                List<String> path = getPath(current);
                OutputHandler.displayPath(path.toArray(new String[0])); 
                OutputHandler.displayVisitedNodes(visitedNodes); 
                OutputHandler.displayExecutionTime(executionTime); 
                return;
            }

            for (String neighbor : getNeighbors(currentWord)) {
                if (!visited.contains(neighbor)) {
                    int cost = current.getCost() + 1;
                    int heuristic = calculateHeuristic(neighbor, endWord);
                    queue.offer(new Node(neighbor, current, cost, heuristic));
                }
            }
        }

        System.out.println("No solution found.");
    }

    private Set<String> loadDictionary(String filename) {
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

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != originalChar) {
                    chars[i] = c;
                    String neighbor = new String(chars);
                    if (dictionary.contains(neighbor)) {
                        neighbors.add(neighbor);
                    }
                }
            }
            chars[i] = originalChar;
        }
        return neighbors;
    }

    private int calculateHeuristic(String word1, String word2) {
        int distance = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    private List<String> getPath(Node node){
        List<String> path = new ArrayList<>();
        while (node != null) {
            path.add(0, node.getWord());
            node = node.getParent();
        }
        System.out.println("Solution found:");
        System.out.println(String.join(" -> ", path));
        return path;
    }
}
