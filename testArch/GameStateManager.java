import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;


class GameStateManager implements EventListener {
  private EventManager eventManager;
  private String wordToGuess;
  private HashSet<Character> guessedLetters = new HashSet<>();
  private int remainingGuesses;
  private boolean isGameOver;

  GameStateManager(EventManager manager, String wordToGuess, int maxGuesses) {
    this.eventManager = manager;
    this.wordToGuess = wordToGuess;
    this.remainingGuesses = maxGuesses;
    this.isGameOver = false;

    manager.registerEvent("GAME_START", this);
    manager.registerEvent("GUESS_LETTER", this);
  }

  public void onEvent(String eventType, Object data) {
    if (eventType.equals("GAME_START")) {
      resetGame((String) data);
    } else if (eventType.equals("GUESS_LETTER")) {
      processGuess((char) data);
    }
  }

  private void resetGame(String newWord) {
    this.wordToGuess = newWord;
    this.remainingGuesses = 6;
    this.guessedLetters.clear();
    this.isGameOver = false;
    eventManager.triggerEvent("GAME_RESET", null);
  }

  private void processGuess(char guess) {
    if (wordToGuess.indexOf(guess) >= 0) {
      guessedLetters.add(guess);
      eventManager.triggerEvent("GUESS_CORRECT", guess);
      if (isWordComplete()) {
        eventManager.triggerEvent("LEVEL_UP", null);
      }
    } else {
      remainingGuesses--;
      eventManager.triggerEvent("GUESS_INCORRECT", guess);
      if (remainingGuesses <= 0) {
        isGameOver = true;
        eventManager.triggerEvent("GAME_OVER", wordToGuess);
      }
    }
  }

  private boolean isWordComplete() {
    for (char c : wordToGuess.toCharArray()) {
      if (!guessedLetters.contains(c)) return false;
    }
    return true;
  }
}
