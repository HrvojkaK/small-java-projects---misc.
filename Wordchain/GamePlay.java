import java.util.*;
import java.io.*;
/**
 * 
 * takes in the player input, checks if it is valid, and prints a response word.
 * 
 * Used words are stored in usedWords set - if the player typed a word already used,
 * he loses.
 * 
 */
public class GamePlay {
    
    HashMap<String, Set<String>> dictionary;
    Set<String> usedWords;
    char firstLett; // these are chars that will be updated to the last two letter
    char secondLett; //of the last word that was printed (either by program or by player)
    
    public GamePlay(HashMap<String, Set<String>> dictionary){
        this.dictionary = dictionary;
        this.usedWords = new HashSet<String>();
        this.firstLett = '\n';
        this.secondLett = '\n';
    }
    
    public boolean checkPlayerInput(String word){
        boolean gameover = true;
        String currKey = word.substring(0,2);
        
        //check if the player entered a word that was already used
        if (usedWords.contains(word)){
            System.out.println("This word has already been used! Sorry, you lost!");
            gameover = false;
        } else if(firstLett != '\n' && word.charAt(1) != secondLett && word.charAt(0) != firstLett){
            //player has entered an invalid word- it doesn't start with last two letters of previous one
            System.out.println("This word doesn't start with the last two letters of the previous one! Sorry, you lost!");
            gameover = false;
        } else {
            //check if player entered a word that isn't in the dictionary
            if(!dictionary.get(currKey).contains(word)){
                System.out.println("There is no '" + word 
                +"' in the spanish dictionary. Sorry, you lost!");
                gameover = false;
            } else {//player entered a word that is in the dictionary
                //find the last two letters of word and choose a new word starting with those
                String lastLett = word.substring(word.length()-2,word.length());
                chooseWord(lastLett);
                //...and add player's word to usedWords set.
                usedWords.add(word);
            }
        }
    
        return gameover;
    }

    public void chooseWord(String theKey){
        //using theKey passed in, choose a new response word from dictionary starting with theKey
        //print this word, add it to usedWords set, and remove it from dictionary map
        Iterator<String> it = dictionary.get(theKey).iterator();
        String response = it.next();
        
        System.out.println(response);
        dictionary.get(theKey).remove(response);
        usedWords.add(response);
        
        firstLett = response.charAt(response.length()-2);
        secondLett = response.charAt(response.length()-1);
    }
}
