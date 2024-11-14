import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordManager {
    private int currentWordNum;
    private int currentLevelNum;
    private List<String> levelCategories;
    private List<Integer> numPerCategory;
    private List<String> animals;

    public WordManager() {
        // Current word in category starts at zero
        currentWordNum = 0;

        // Current category or level is the first element in levelCategories
        currentLevelNum = 0;

        // diffenent words for different categories
        animals = new ArrayList<String>(Arrays.asList("lion", "zebra", "tiger"));

        // All categories
        levelCategories = new ArrayList<String>(Arrays.asList("animals"));
        
        // The number of words for each category
        numPerCategory = new ArrayList<Integer>(Arrays.asList(3));
        
        // setup all the categories
        
    }

    public String getNextWord() {
        // Logic to select the next word
        return animals.get(currentWordNum);
    }

    public void nextLevel() {
        // Logic to proceed to the next level
        
    }

    public void handleLevelUp() {
        // Logic to handle leveling up
    }
  
    public void reset() {
        // Logic to reset for a new level
    }
}
