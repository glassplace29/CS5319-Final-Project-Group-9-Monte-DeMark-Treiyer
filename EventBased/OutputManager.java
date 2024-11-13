public class OutputManager {
  private EventManager manage;

  public OutputManager(EventManager manage) {
      this.manage = manage;
  }

  public void displayMessage(String message) {
      // Logic to display a message
  }

  public void displayInstructions() {
      // Logic to display instructions
  }

  public void updateGameStatus(GameStateManager gameState) {
      // Logic to update game status
  }

  public void displayGameOver(boolean playerWon) {
      // Logic to display game over message
  }
}
