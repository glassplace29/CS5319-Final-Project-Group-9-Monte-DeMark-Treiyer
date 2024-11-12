EventManager eventManager;
GameStateManager gameStateManager;
CorrectGuessHandler correctGuessHandler;
IncorrectGuessHandler incorrectGuessHandler;
Draw drawManager; // Handles hangman drawing

void setup() {
  size(600, 400);
  eventManager = new EventManager();

  // Initialize game components and register them with the event manager
  String initialWord = "example"; // Start with an example word
  int maxGuesses = 6;

  gameStateManager = new GameStateManager(eventManager, initialWord, maxGuesses);
  correctGuessHandler = new CorrectGuessHandler(eventManager);
  incorrectGuessHandler = new IncorrectGuessHandler(eventManager, maxGuesses);
  drawManager = new Draw(eventManager);

  // Start the game
  eventManager.triggerEvent("GAME_START_WORD", "example"); // Pass the word to guess
  eventManager.triggerEvent("GAME_START_GUESSES", 6); // Pass the max guesses

}

void draw() {
  background(255);
  drawManager.display(); // Display the hangman drawing

  // Display game messages and progress from other components
  textSize(20);
  fill(0);
  text("Guessed Letters: " + correctGuessHandler.getGuessedLetters(), width / 2, 50);
  text("Remaining Guesses: " + incorrectGuessHandler.getRemainingGuesses(), width / 2, 90);
  text("Word: " + correctGuessHandler.getWordProgress(), width / 2, 130);
}

// Handle keyboard input for guesses
void keyPressed() {
  if (Character.isLetter(key)) {
    char guessedLetter = Character.toLowerCase(key);
    eventManager.triggerEvent("GUESS_LETTER", guessedLetter);
  }
}
