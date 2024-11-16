import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Field;


public class WordManager {
    private int currentWordNum;
    private int currentLevelNum;
    private List<String> levelCategories;
    private List<Integer> numPerCategory;
    private List<String> animals;
    private List<String> countries;

    public WordManager() {
        // Current word in category starts at zero
        currentWordNum = 0;

        // Current category or level is the first element in levelCategories
        currentLevelNum = 0;

        // different words for different categories
        animals = new ArrayList<String>(Arrays.asList("lion", "zebra", "tiger"));
        countries = new ArrayList<String>(Arrays.asList("argentina", "usa", "brazil"));

        // All categories
        levelCategories = new ArrayList<String>(Arrays.asList("animals", "countries"));
        
        // The number of words for each category
        numPerCategory = new ArrayList<Integer>(Arrays.asList(3));
        
        // setup all the categories
        
    }

    public String getNextWord() {
        // Logic to select the next word
        currentWordNum ++;
        if(currentWordNum >= numPerCategory.get(currentLevelNum)){
            currentWordNum = 0;
            currentLevelNum ++;
        }
        if(currentLevelNum >= levelCategories.size()){
            return "Game Complete";
        }

        String categtory = levelCategories.get(currentLevelNum);
        Field categoryVar =

    }

    public boolean levelUp() {
        // Logic to proceed to the next level
        
    }
  
    public void reset() {
        // Logic to reset for a new level
        currentWordNum = 0;
        currentLevelNum = 0;
    }

    public String getLevelCategory() {
        return levelCategories.get(currentLevelNum);
    }
}
