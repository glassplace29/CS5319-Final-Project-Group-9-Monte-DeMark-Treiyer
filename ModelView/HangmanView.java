
import java.awt.*;
import java.util.Set;
import javax.swing.*;

public class HangmanView extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    private JPanel startScreen;
    private JPanel gameScreen;
    private JPanel endScreen;
    private JPanel infoPanel;

    private JLabel wordLabel;
    private JLabel guessedLettersLabel;
    private JLabel remainingGuessesLabel;
    private JPanel hangmanDrawingPanel;
    private JTextField inputField;
    private JLabel endMessageLabel;
    private JLabel themeLabel;
    private JButton[] letterButtons;

    private GameController gameController;

    public HangmanView(GameController controller) {
        this.gameController = controller;

        // Set up the JFrame
        setTitle("Hangman Game");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up CardLayout and main panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Initialize screens
        initializeStartScreen();
        initializeGameScreen();
        initializeEndScreen();

        // Add screens to the main panel
        mainPanel.add(startScreen, "StartScreen");
        mainPanel.add(gameScreen, "GameScreen");
        mainPanel.add(endScreen, "EndScreen");

        add(mainPanel);
        setVisible(true);

        // Show the start screen initially
        showStartScreen();
    }

    private void initializeStartScreen() {
      startScreen = new JPanel();
      startScreen.setLayout(new BorderLayout());

      JLabel titleLabel = new JLabel("Welcome to Hangman!", SwingConstants.CENTER);
      titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
      startScreen.add(titleLabel, BorderLayout.CENTER);

      JButton startButton = new JButton("Start Game");
      startButton.addActionListener(e -> gameController.startGame());
      startScreen.add(startButton, BorderLayout.SOUTH);
    }

    private void initializeGameScreen() {
      gameScreen = new JPanel(new BorderLayout());
  
      // Initialize labels
      themeLabel = new JLabel("Theme: ");
      wordLabel = new JLabel("Word: ");
      guessedLettersLabel = new JLabel("Guessed Letters: ");
      remainingGuessesLabel = new JLabel("Remaining Guesses: ");
  
      // Set fonts for labels
      themeLabel.setFont(new Font("Arial", Font.BOLD, 16));
      wordLabel.setFont(new Font("Arial", Font.BOLD, 16));
      guessedLettersLabel.setFont(new Font("Arial", Font.PLAIN, 16));
      remainingGuessesLabel.setFont(new Font("Arial", Font.PLAIN, 16));
  
      // Initialize infoPanel and add labels
      infoPanel = new JPanel();
      infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS)); // Vertical alignment
      infoPanel.add(themeLabel);
       // creates a space 
      infoPanel.add(Box.createVerticalStrut(5)); 
      infoPanel.add(wordLabel);
      // creates a space 
      infoPanel.add(Box.createVerticalStrut(15)); 
      infoPanel.add(guessedLettersLabel);
      infoPanel.add(remainingGuessesLabel);
      infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
      
  
      // Create the hangmanDrawingPanel
      hangmanDrawingPanel = new JPanel() {
          @Override
          protected void paintComponent(Graphics g) {
              super.paintComponent(g);
              // Draw the hangman based on incorrect guesses
              drawHangman(g, gameController.getGameState().getIncorrectGuesses());
          }
      };
      hangmanDrawingPanel.setPreferredSize(new Dimension(350, 300)); // Adjust size for drawing
      gameScreen.add(hangmanDrawingPanel, BorderLayout.WEST);
  
      // Create a container to center-align infoPanel
      JPanel infoContainer = new JPanel(new GridBagLayout());
      infoContainer.add(infoPanel); // Center the info panel
      gameScreen.add(infoContainer, BorderLayout.CENTER);
  
      // Bottom section for alphabet buttons
      JPanel alphabetPanel = new JPanel(new GridLayout(2, 13, 3, 3)); // 2 rows, 13 columns, less space
      letterButtons = new JButton[26];
      for (int i = 0; i < 26; i++) {
          char letter = (char) ('A' + i);
          letterButtons[i] = new JButton(String.valueOf(letter));
          letterButtons[i].setFont(new Font("Arial", Font.BOLD, 14));
          letterButtons[i].setPreferredSize(new Dimension(40, 40)); // Square buttons
          letterButtons[i].setBackground(Color.LIGHT_GRAY);
          letterButtons[i].addActionListener(e -> {
              gameController.processGuess(Character.toLowerCase(letter));
              ((JButton) e.getSource()).setEnabled(false); // Disable button after click
          });
          alphabetPanel.add(letterButtons[i]);
      }
  
      gameScreen.add(alphabetPanel, BorderLayout.SOUTH);
  }  

    private void initializeEndScreen() {
        endScreen = new JPanel(new BorderLayout());

        endMessageLabel = new JLabel("", SwingConstants.CENTER);
        endMessageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        endScreen.add(endMessageLabel, BorderLayout.CENTER);

        JButton restartButton = new JButton("Play Again");
        restartButton.addActionListener(e -> {
            gameController.resetToLevelOne(); // Reset to Level 1
            gameController.startGame();
        });
        endScreen.add(restartButton, BorderLayout.SOUTH);
    }
  
    public void showStartScreen() {
        cardLayout.show(mainPanel, "StartScreen");
    }

    public void showGameScreen() {
        cardLayout.show(mainPanel, "GameScreen");
    }

    public void showWinScreen(String message) {
        endMessageLabel.setText(message); // Display win message
        JButton nextLevelButton = new JButton("Next Level");
        nextLevelButton.addActionListener(e -> gameController.startGame());

        endScreen.removeAll(); // Clear the end screen
        endScreen.setLayout(new BorderLayout());
        endScreen.add(endMessageLabel, BorderLayout.CENTER);
        endScreen.add(nextLevelButton, BorderLayout.SOUTH);

        cardLayout.show(mainPanel, "EndScreen");
    }

    public void showEndScreen(String message) {
      endScreen.removeAll(); // Clear all components from the end screen
      endScreen.setLayout(new BoxLayout(endScreen, BoxLayout.Y_AXIS)); // Use vertical alignment
  
      // Add spacing at the top
      endScreen.add(Box.createVerticalStrut(100)); // Add vertical spacing
  
      // Congratulations message
      JLabel congratsMessage = new JLabel(message, SwingConstants.CENTER);
      congratsMessage.setFont(new Font("Arial", Font.BOLD, 16));
      congratsMessage.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the text
      endScreen.add(congratsMessage);
  
      // Add spacing between message and button
      endScreen.add(Box.createVerticalStrut(20)); // Add vertical spacing
  
      // Play Again button
      JButton playAgainButton = new JButton("Play Again");
      playAgainButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the button
      playAgainButton.addActionListener(e -> {
          gameController.resetToLevelOne(); // Reset the game to level 1
          gameController.startGame();
      });
      endScreen.add(playAgainButton);
  
      cardLayout.show(mainPanel, "EndScreen"); // Display the updated end screen
  }
  
  
    private void drawHangman(Graphics g, int incorrectGuesses) {
      Graphics2D g2d = (Graphics2D) g;
  
      // Get panel dimensions
      int panelWidth = hangmanDrawingPanel.getWidth();
      int panelHeight = hangmanDrawingPanel.getHeight();
  
      // Calculate base offsets to center the drawing
      int baseX = panelWidth / 2 - 75; // Adjusted to center horizontally
      int baseY = panelHeight / 2 - 100; // Adjusted to center vertically
  
      // Adjusted scaling and offsets for better centralization
      int scale = 1;
  
      // Draw base
      g2d.setStroke(new BasicStroke(3)); // Thicker lines for visibility
      g2d.drawLine(baseX, baseY + 200 * scale, baseX + 100 * scale, baseY + 200 * scale); // Ground
      g2d.drawLine(baseX + 50 * scale, baseY + 200 * scale, baseX + 50 * scale, baseY); // Pole
      g2d.drawLine(baseX + 50 * scale, baseY, baseX + 100 * scale, baseY); // Top beam
      g2d.drawLine(baseX + 100 * scale, baseY, baseX + 100 * scale, baseY + 40 * scale); // Rope
  
      // Draw parts of the hangman based on incorrect guesses
      if (incorrectGuesses >= 1) g2d.drawOval(baseX + 90 * scale, baseY + 40 * scale, 20 * scale, 20 * scale); // Head
      if (incorrectGuesses >= 2) g2d.drawLine(baseX + 100 * scale, baseY + 60 * scale, baseX + 100 * scale, baseY + 120 * scale); // Body
      if (incorrectGuesses >= 3) g2d.drawLine(baseX + 100 * scale, baseY + 80 * scale, baseX + 110 * scale, baseY + 100 * scale); // Right arm
      if (incorrectGuesses >= 4) g2d.drawLine(baseX + 100 * scale, baseY + 80 * scale, baseX + 90 * scale, baseY + 100 * scale); // Left arm
      if (incorrectGuesses >= 5) g2d.drawLine(baseX + 100 * scale, baseY + 120 * scale, baseX + 110 * scale, baseY + 140 * scale); // Right leg
      if (incorrectGuesses >= 6) g2d.drawLine(baseX + 100 * scale, baseY + 120 * scale, baseX + 90 * scale, baseY + 140 * scale); // Left leg
  }
  
  public void resetKeyboard() {
    for (JButton button : letterButtons) {
        button.setEnabled(true); // Ensure all buttons are enabled
    }
    hangmanDrawingPanel.repaint(); // Clear the drawing panel for the new level
  }

    public void updateTheme(String theme) {
        themeLabel.setText("Theme: " + theme);
    }

    public void updateDisplay(String displayWord, Set<Character> guessedLetters, int remainingGuesses) {
        wordLabel.setText("Word: " + displayWord);
        guessedLettersLabel.setText("Guessed Letters: " + guessedLetters.toString());
        remainingGuessesLabel.setText("Remaining Guesses: " + remainingGuesses);
        hangmanDrawingPanel.repaint();
    }
}

