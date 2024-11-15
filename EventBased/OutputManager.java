import javax.swing.JOptionPane;

public class OutputManager {

    IntellijUserInterface UI;
    JOptionPane pane;

    public OutputManager(IntellijUserInterface UI){
        this.UI = UI;
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

    // public int displayGameOver(boolean playerWon) {
        // Logic to display game over message
//        pane.showMessageDialog
//        return
    }


