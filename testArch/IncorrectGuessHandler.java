class IncorrectGuessHandler implements EventListener {
  private EventManager eventManager;
  private int remainingGuesses;

  IncorrectGuessHandler(EventManager manager, int maxGuesses) {
    this.eventManager = manager;
    this.remainingGuesses = maxGuesses;

    manager.registerEvent("GUESS_INCORRECT", this);
    manager.registerEvent("GAME_START_GUESSES", this);
  }

  public void onEvent(String eventType, Object data) {
    if (eventType.equals("GUESS_INCORRECT")) {
      remainingGuesses--;
      eventManager.triggerEvent("DRAW_NEXT_PART", remainingGuesses);
    } else if (eventType.equals("GAME_START_GUESSES")) {
      remainingGuesses = (int) data; // Reset on new game
    }
  }

  int getRemainingGuesses() {
    return remainingGuesses;
  }
}
