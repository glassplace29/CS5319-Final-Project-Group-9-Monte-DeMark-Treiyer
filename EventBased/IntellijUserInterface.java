import javax.swing.*;
import java.lang.reflect.Field;

public class IntellijUserInterface extends JFrame {
    private JPanel MainWindow;

    // Letter Design Panel
    private JPanel LetterDesign;

    private JPanel FirstRow;
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    private JButton dButton;
    private JButton eButton;
    private JButton fButton;
    private JButton gButton;
    private JButton hButton;

    private JPanel SecondRow;
    private JButton jButton;
    private JButton kButton;
    private JButton lButton;
    private JButton mButton;
    private JButton nButton;
    private JButton oButton;
    private JButton pButton;
    private JButton qButton;
    private JButton iButton;
    private JButton rButton;

    private JPanel ThirdRow;
    private JButton sButton;
    private JButton tButton;
    private JButton uButton;
    private JButton vButton;
    private JButton wButton;
    private JButton xButton;
    private JButton yButton;
    private JButton zButton;

    // Guess Part of the UI
    private JPanel GuessHolder;
    private JLabel BigText;
    private JLabel CategoryText;
    private JLabel IncorectGuessesText;

    // Hangman Image Part of the UI
    private JPanel HangManHolder;
    private JLabel HangManImage;


    public IntellijUserInterface() {
        setTitle("Hangman - CS 5319 Final Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // This initializes all the fields, sets it up how I have it in Intellij IDEA UI designer tool
        $$$setupUI$$$();

        // this sets up the action command of all the letter buttons
        setupButtons();

        pack();
    }

    private void setupButtons(){
        for (char letter = 'a'; letter <= 'z'; letter++) {
            try {
                // Construct the variable name, e.g., "aButton"
                String fieldName = letter + "Button";

                // Access the field by name from the class
                Field field = this.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);

                // Get the JButton object and set its ActionCommand to the letter
                JButton button = (JButton) field.get(this);
                button.setActionCommand(String.valueOf(letter));

                // For testing, print out each button's ActionCommand
                System.out.println("Set ActionCommand for " + fieldName + ": " + button.getActionCommand());

            }

            catch (NoSuchFieldException | IllegalAccessException e) {
                // Handle case where the field doesn't exist, or cannot be accessed
                System.out.println("No button found for: " + letter);
            }
        }
    }

    public static void main(String[] args) {
        IntellijUserInterface frame = new IntellijUserInterface();
        frame.setVisible(true);
    }
}
