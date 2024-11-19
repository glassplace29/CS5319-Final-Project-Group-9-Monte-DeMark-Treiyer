
import java.util.*; 

public class WordManager {
  private Map<Integer, List<String>> categories;
  private String currentWord; 

  public WordManager() {
    loadCategories(); 
  }

  // function loads words into categories depending on the level 
  public void loadCategories() {
    categories = new HashMap<>();   // hash map created for the categories 
    // Level 1 - Easiest 
    categories.put(1, Arrays.asList("apple", "banana", "grape")); 
    // Level 2 - Medium 
    categories.put(2, Arrays.asList("computer", "programming", "java")); 
    // Level 3 - Hard
    categories.put(3, Arrays.asList("hangman", "complexity", "algorithm"));
    // add more and change categories later 
  }

  public String selectRandomWord(int level) {
    // check for null 
    List<String> words = categories.get(level);
    if (words == null || words.isEmpty()) {
        return null; // return null if no words are found for the level
    }
    currentWord = words.get(new Random().nextInt(words.size()));
    return currentWord;
}

  public String getCurrentWord() {
    return currentWord; 
  }

  // checks if there is a next level or not 
  public boolean hasNextLevel(int level) {
    return categories.containsKey(level + 1); 
  }
}

