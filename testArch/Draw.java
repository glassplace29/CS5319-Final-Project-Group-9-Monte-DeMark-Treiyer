class Draw implements EventListener {
  private int bodyPartsDrawn;

  Draw(EventManager eventManager) {
    eventManager.registerEvent("DRAW_NEXT_PART", this);
    eventManager.registerEvent("GAME_START", this);
    this.bodyPartsDrawn = 0;
  }

  public void onEvent(String eventType, Object data) {
    if (eventType.equals("DRAW_NEXT_PART")) {
      bodyPartsDrawn = 6 - (int) data; // Update number of parts to draw
    } else if (eventType.equals("GAME_START")) {
      bodyPartsDrawn = 0;
    }
  }

  void display() {
    // Draw hangman based on bodyPartsDrawn
    // E.g., if bodyPartsDrawn >= 1, draw head; if >= 2, draw body, etc.
  }
}
