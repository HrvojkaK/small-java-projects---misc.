import java.util.*;

/**
 *  
 * welcomes the player, explains the rules
 * runs the game with player input                    
 */

public class Main {
    public static void main(String[] args){
        
        ReadDictFile rf = new ReadDictFile();
        GamePlay gameplay = new GamePlay(rf.makeDict());
        
        boolean gameover = true;  //game ends when gameover is set to false    
        
        String input = ""; //initial empty string for user input
        Scanner sc = new Scanner(System.in); 
        
        System.out.println("Welcome!");
        //explain the rules
        System.out.println("We'll be playing word chain game with spanish words.");
        System.out.println("You can start. Type in a word, and I'll write a new one, that begins with");
        System.out.println("the last two letters of your word. ");
        System.out.println("Then you need to type a new, unique word starting with the last two letters of mine!");
        System.out.println("");
        System.out.println("If you enter a word that has already been used, or isn't contained in the dictionary, you lose. OK?");
        System.out.println("");
        System.out.println("Let's start:");
        
        do{
            input = sc.nextLine().toLowerCase();
            gameover = gameplay.checkPlayerInput(input);
        
        } while(gameover == true);
        
        System.out.println("");
        System.out.println("");
    }

}
