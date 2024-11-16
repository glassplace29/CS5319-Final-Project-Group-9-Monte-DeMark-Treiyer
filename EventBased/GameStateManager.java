import java.util.List;
import java.util.ArrayList;

public class GameStateManager {

    GuessWordDisplay guess;
    WordManager wordManager;
    OutputManager output;
    
    private int remainingGuesses;
    private String wordToGuess;
    private boolean isGameOver;
    private boolean isWordGuessed;
    

    public GameStateManager() {
        wordManager = new WordManager();
        nextWord();
    }

    public void nextWord() {
        // Initialize game logic
        wordToGuess = wordManager.getNextWord();
        guess = new GuessWordDisplay(wordToGuess);
        remainingGuesses = 6;
        isGameOver = false;
    }

    public boolean guessLetter(char letter) {
        // Handle guess logic
        boolean result = guess.handleGuess(letter);
        if(!result){
            remainingGuesses -= 1;
            if(remainingGuesses == 0){
                isGameOver = true;
            }
        }
        return result;
    }

    public boolean checkGameStatus() {
        // Logic to check the game's status
        return isGameOver;
    }

    public boolean isWordGuessed() {
        return isWordGuessed;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }
    public int getRemainingGuesses(){
        return remainingGuesses;
    }
}
