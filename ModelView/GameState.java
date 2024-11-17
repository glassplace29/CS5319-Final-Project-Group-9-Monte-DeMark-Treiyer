
import java.util.HashSet;
import java.util.Set;

public class GameState {
    private String word;
    private int maxGuesses = 6;
    private int remainingGuesses;
    private int incorrectGuesses; 
    private Set<Character> guessedLetters;
    private String displayWord;

    public GameState(String word) {
        this.word = word;
        this.remainingGuesses = maxGuesses;
        this.guessedLetters = new HashSet<>();
        this.displayWord = "_".repeat(word.length());
    }

    public int getIncorrectGuesses() {
      return incorrectGuesses; 
    }

    public boolean updateState(char guess) {
        // If the letter was already guessed, don't decrement guesses
        if (guessedLetters.contains(guess)) {
           return false; // letter already guessed 
        }
        guessedLetters.add(guess);

        // Check if the guess is correct
        if (word.indexOf(guess) >= 0) {
            updateDisplayWord(guess);
            return true; // correct guess 
        } else {
            incorrectGuesses++;  // increment incorrect guesses 
            remainingGuesses--;  // decrement remaining guesses
            return false;
        }
    }

    private void updateDisplayWord(char guess) {
        StringBuilder newDisplay = new StringBuilder(displayWord);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                newDisplay.setCharAt(i, guess);
            }
        }
        displayWord = newDisplay.toString();
    }

    public boolean isGameOver() {
        return remainingGuesses <= 0 || isWordComplete();
    }

    public boolean isWordComplete() {
        // Check if displayWord has any underscores left
        return !displayWord.contains("_");
    }

    // Getters
    public int getRemainingGuesses() { return remainingGuesses; }
    public Set<Character> getGuessedLetters() { return guessedLetters; }
   
    public String getDisplayWord() {
      return String.join(" ", displayWord.split(""));
    }
  
    public String getWord() { return word; }
}

