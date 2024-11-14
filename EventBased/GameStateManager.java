import java.util.HashSet;
import java.util.Set;

public class GameStateManager {
    private String wordToGuess;
    private Set<Character> guessedLetters = new HashSet<>();
    private int remainingGuesses;
    private boolean isGameOver;

    GuessHandler guess = new GuessHandler();
    WordManager wordManager = new WordManager();
    OutputManager output

    public GameStateManager() {
        guess = new GuessHandler();
        wordManager = new WordManager();
        output = new OutputManager();
    }

    public void initializeGame(String word, int maxGuesses) {
        // Initialize game logic
        wordToGuess = LevelManager.getNextWord()

    }

    public void handleGuess(char letter, boolean isCorrect) {
        // Handle guess logic
    }

    private void checkGameStatus() {
        // Logic to check the game's status
    }
}
