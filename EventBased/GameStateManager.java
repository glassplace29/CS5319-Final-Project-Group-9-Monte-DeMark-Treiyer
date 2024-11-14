import java.util.List;
import java.util.ArrayList;

public class GameStateManager {
    

    GuessWordDisplay guess;
    WordManager wordManager;
    OutputManager output;
    
    private int remainingGuesses;
    private String wordToGuess;
    private boolean isGameOver;
    

    public GameStateManager() {
        wordManager = new WordManager();
        initializeGame();
    }

    public void initializeGame() {
        // Initialize game logic
        wordToGuess = wordManager.getNextWord();
        guess = new GuessWordDisplay(wordToGuess);
        remainingGuesses = 6;
        isGameOver = false;
    }

    public void guessLetter(char letter) {
        // Handle guess logic
        boolean result = guess.handleGuess(letter);
        if(!result){
            remainingGuesses -= 1;
            if(remainingGuesses == 0){
                isGameOver = true;
            }
        }
    }

    private boolean checkGameStatus() {
        // Logic to check the game's status
        return isGameOver;
    }
}
