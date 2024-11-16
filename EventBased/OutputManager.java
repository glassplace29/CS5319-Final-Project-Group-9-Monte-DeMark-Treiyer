import javax.swing.JOptionPane;

public class OutputManager {

    IntellijUserInterface UI;
    EventManager eventManager;

    public OutputManager(IntellijUserInterface UI, EventManager eventManager) {
        this.UI = UI;
        this.eventManager = eventManager;
    }

    public void levelUpMessage(String message) {
        // Logic to display a message
    }

    public void displayInstructions() {
        // Logic to display instructions
        String instructionMessage = "How to play:\n" +
                "Guess a word that corresponds to the category. If you don't\n" +
                "guess the word before the stick figure is hung, you lose!";

        JOptionPane.showMessageDialog(null, instructionMessage);
    }

    public void displayGameOver() {
        JOptionPane.showMessageDialog(null, "Game Over!\nThe correct word was: " + eventManager.gameStateManager.getWordToGuess());

    }
}
