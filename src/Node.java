public class Node {
    private String word;
    private Node parent;
    private int cost;
    private int heuristic;

    public Node(String word, Node parent, int cost) {
        this.word = word;
        this.parent = parent;
        this.cost = cost;
    }

    public Node(String word, Node parent, int cost, int heuristic) {
        this.word = word;
        this.parent = parent;
        this.cost = cost;
        this.heuristic = heuristic;
    }


    public String getWord() {
        return word;
    }

    public Node getParent() {
        return parent;
    }

    public int getCost() {
        return cost;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public int getTotalCost() {
        return cost + heuristic;
    }
}
