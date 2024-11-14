import java.util.ArrayList;
import java.util.List;

public class GuessWordDisplay {

    String guessWord;
    StringBuilder guessWordDisplay;
    int lengthOfWord;
    List<Character> unguessedLetters;
    List<Character> guessedLetters;
    

    public GuessWordDisplay(String word) {
        guessWord = word;
        StringBuilder sb = new StringBuilder();
        lengthOfWord = word.length();

        for(int i = 0; i < word.length(); i++){
          sb.append("_");
          unguessedLetters.add(word.charAt(i));
        }

        guessWordDisplay = sb;
    }

    public boolean handleGuess(char letter) {
      // Logic to handle a guess
      if(unguessedLetters.contains(letter)){
        // reveal in guessWordDisplay
        revealLetter(letter);

        // Remove from unguessed letters if it is in there
        unguessedLetters.removeIf(let -> let == letter);

        // add to guessed letters
        guessedLetters.add(letter);
        return true;
      }
      guessedLetters.add(letter);
      return false;
    }

    private void revealLetter(char letter) {
      // Logic to reveal the letter
      for(int i = 0; i < lengthOfWord; i++){
        if(guessWord.charAt(i) == letter){
          guessWordDisplay.setCharAt(i, letter);
        }
      }
    }
}
