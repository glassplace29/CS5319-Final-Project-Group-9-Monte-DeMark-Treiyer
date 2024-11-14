import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class EventListener implements ActionListener{

  UserInterace UI;

  // So I can controll fields in UI
  EventListener(UserInterace UI){
    this.UI = UI;
  }

  public void actionPerformed(ActionEvent event){
      String action = event.getActionCommand();
      
      for(String letter : UserInterace.ALPHABET){
        if(action.equals(letter)){
            UI.GameState.guessLetter(letter.charAt(0));
        }
      }
  }
}