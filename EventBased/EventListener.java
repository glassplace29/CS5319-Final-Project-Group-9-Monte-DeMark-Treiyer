import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class EventListener implements ActionListener{

  IntellijUserInterface UI;

  // So I can controll fields in UI
  EventListener(IntellijUserInterface UI){
    this.UI = UI;
  }

  public void actionPerformed(ActionEvent event){
      char theLetter = event.getActionCommand().charAt(0);

      // Guess the letter and get the result
      boolean result = UI.gameStateManager.guessLetter(theLetter);

      // Check if the game is over
      if(UI.gameStateManager.checkGameStatus()){
      }

      // Check if level up

      // take that letter off the display
      UI.disableLetterButton(theLetter);

      // if not, check if result is correct and display letters if not
      // draw part of the hang man otherwise and augment strikes
      if(result){
          String currentDisplay = UI.gameStateManager.guess.getGuessWordDisplay();
          UI.changeBigTextDisplay(currentDisplay);
      }
      else{
          int remainingGuesses = UI.gameStateManager.getRemainingGuesses();
          UI.changeHangManImage(UI.draw.drawNextPart(remainingGuesses));
          UI.changeIncorectGuessesTextDisplay(remainingGuesses);
      }


    }
}