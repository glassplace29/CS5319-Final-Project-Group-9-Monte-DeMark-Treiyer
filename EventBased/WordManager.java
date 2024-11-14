import java.util.ArrayList;
import java.util.List;

public class WordManager {
    private int currentWord;
    private List<String> levelCategories;
    private int[] numPerCategory;
    private List<String> animals;

    public WordManager() {
        currentWord = 0;
        
        // setup all the categories
        animals = new ArrayList<String>();
        animals.add("lion");
        animals.add("zebra");
    }

    public String getNextWord() {
        // Logic to select the next word
        return animals.get(currentLevel);
        
    }

    public void nextWord() {
        // Logic to proceed to the next level
        currentWord += 1;
    }

    public void handleLevelUp() {
        // Logic to handle leveling up
    }
  
    public void reset() {
        // Logic to reset for a new level
    }
}
