import javax.swing.JOptionPane;

public class OutputManager {

    UserInterface UI;
    JOptionPane pane;

    public OutputManager(UserInterface UI){
        this.UI = UI;
    }

    public void levelUpMessage(String message) {
        // Logic to display a message
    }

    public void displayInstructions() {
        // Logic to display instructions
        String instructionMessage = "How to play:\n" +
                                    "Guess a word that corresponds to the category. If you don't\n" +
                                    "guess the word befor the stick figure is hung, you lose!";

        pane.showMessageDialog(UI, instructionMessage, "Instructions", JOptionPane.DEFAULT_OPTION);
    }

    // public int displayGameOver(boolean playerWon) {
        // Logic to display game over message
//        pane.showMessageDialog
//        return
    }


