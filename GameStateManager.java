import java.util.HashSet;
import java.util.Set;

public class GameStateManager {
    private EventManager manage;
    private String wordToGuess;
    private Set<Character> guessedLetters = new HashSet<>();
    private int remainingGuesses;
    private boolean isGameOver;

    public GameStateManager(EventManager manage) {
        this.manage = manage;
    }

    public void initializeGame(String word, int maxGuesses) {
        // Initialize game logic
    }

    public void handleGuess(char letter, boolean isCorrect) {
        // Handle guess logic
    }

    private void checkGameStatus() {
        // Logic to check the game's status
    }
}
