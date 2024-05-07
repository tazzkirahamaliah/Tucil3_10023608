import java.util.Set;

public class WordValidator {
    private Set<String> dictionary;

    public WordValidator(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isValidWord(String word) {
        return dictionary.contains(word);
    }
}
