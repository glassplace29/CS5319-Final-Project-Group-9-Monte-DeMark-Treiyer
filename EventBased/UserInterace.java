import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;


public class UserInterace extends JFrame{
    public static final String[] ALPHABET = {
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
        "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    };

    JPanel hangManImage;
    JPanel guesserLabel;
    JPanel buttonPanel;
    GameStateManager GameState;

    public UserInterace() {
        // names the window
        super("Hangman - CS 5319");
        
        // sets window size
        setSize(300, 200);
        
        // makes sure clicking x closes the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creates action listener
        EventListener listener = new EventListener(this);

        // Create the Hangman image
        hangManImage = new JPanel();

        // Create the guesser label
        guesserLabel = new JPanel();

        // Creates a panel of alphabet buttons
        buttonPanel = new JPanel();

        // Makes a grid
        buttonPanel.setLayout(new GridLayout(4, 7, 5, 5));

        // creates buttons for each letter in alphabet
        for (String letter : ALPHABET) {
            JButton button = new JButton(letter);
            button.setActionCommand(letter);
            button.addActionListener(listener);
            buttonPanel.add(button);
        }
    }

    public static void main(String[] args){
        UserInterace example = new UserInterace();
        example.setVisible(true);
    }
}
