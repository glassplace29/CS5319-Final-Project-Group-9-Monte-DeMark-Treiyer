
public class GameController {
  private GameState gameState; 
  private WordManager wordManager; 
  private HangmanView hangmanView; 
  private int currentLevel = 1; 

  public GameController() {
    wordManager = new WordManager(); 
    hangmanView = new HangmanView(this);  // pass 'this' to HangmanView
    hangmanView.showStartScreen(); 

    // hangmanView.setVisible(true); 
    // startGame(); 
  }

  public void startGame() {
    hangmanView.resetKeyboard();
    String word = wordManager.selectRandomWord(currentLevel); 
    gameState = new GameState(word); 
    hangmanView.showGameScreen(); 
    hangmanView.updateTheme(getLevelTheme(currentLevel)); // update theme
    updateView(); 
  }
  
  public void processGuess(char guess) {
    boolean correct = gameState.updateState(guess); 
    updateView();  // Update view after processing the guess 
    
    if (gameState.isGameOver()) {
        if (gameState.isWordComplete()) {
            // hangmanView.resetKeyboard(); // Reset the keyboard when the word is guessed
            if (wordManager.hasNextLevel(currentLevel)) {
                hangmanView.resetKeyboard();
                hangmanView.showWinScreen("Congratulations! You guessed the word!");
                currentLevel++; // Increment to the next level
            } else {
                hangmanView.showEndScreen("Congratulations! You've won the entire game!");
            }
        } else {
            hangmanView.showEndScreen("Game Over! The word was: " + gameState.getWord());
        }
    }
  }


  public void resetToLevelOne() {
    currentLevel = 1;  // resets to level one 
    gameState = null; // Clear the current game state
    hangmanView.resetKeyboard(); // Reset the keyboard state
  }

  public void resetGameView() {
    hangmanView.resetKeyboard(); // Call the method in HangmanView to reset the keyboard
  }

  private String getLevelTheme(int level) {
    switch (level) {
        case 1: return "Fruits";
        case 2: return "Technology";
        case 3: return "Random";
        // Add more themes as needed
        default: return "Unknown Theme";
    }
  }

  public GameState getGameState() {
    return gameState;
  }

  private void updateView() {
    hangmanView.updateDisplay(
      gameState.getDisplayWord(), 
      gameState.getGuessedLetters(), 
      gameState.getRemainingGuesses()
    );
  }

  // Main method to run the program
  public static void main(String[] args) {
    new GameController();
  }
}
