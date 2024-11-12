class CorrectGuessHandler implements EventListener {
  private EventManager eventManager;
  private StringBuilder wordProgress;
  private Set<Character> guessedLetters;

  CorrectGuessHandler(EventManager manager) {
    this.eventManager = manager;
    this.guessedLetters = new HashSet<>();
    this.wordProgress = new StringBuilder(); // Initialize wordProgress here

    manager.registerEvent("GUESS_CORRECT", this);
    manager.registerEvent("GAME_START", this);
  }

  public void onEvent(String eventType, Object data) {
    if (eventType.equals("GUESS_CORRECT")) {
      updateWordProgress((char) data);
    } else if (eventType.equals("GAME_START")) {
      resetWordProgress((String) data); // Ensure resetWordProgress initializes wordProgress
    }
  }

  private void updateWordProgress(char letter) {
    guessedLetters.add(letter);
    StringBuilder newProgress = new StringBuilder();

    // Iterate over the characters in wordProgress based on guessed letters
    for (int i = 0; i < wordProgress.length(); i++) {
      char c = wordProgress.charAt(i);
      newProgress.append(guessedLetters.contains(c) ? c : '_').append(" ");
    }
    wordProgress = newProgress;
  }

  private void resetWordProgress(String word) {
    wordProgress = new StringBuilder("_ ".repeat(word.length())); // Initialize with underscores
  }

  String getWordProgress() {
    return wordProgress.toString();
  }

  String getGuessedLetters() {
    return guessedLetters.toString();
  }
}
