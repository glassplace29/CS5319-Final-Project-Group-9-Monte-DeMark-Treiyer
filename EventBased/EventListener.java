import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class EventListener implements ActionListener{

  UserInterface UI;

  // So I can controll fields in UI
  EventListener(UserInterface UI){
    this.UI = UI;
  }

  public void actionPerformed(ActionEvent event){
      String action = event.getActionCommand();
      
      for(String letter : UserInterface.ALPHABET){
        if(action.equals(letter)){
            UI.GameState.guessLetter(letter.charAt(0));
            if(UI.GameState.checkGameStatus()){
            }
        }
      }
  }
}