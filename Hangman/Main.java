import java.util.*;

/**
 *  
 * talks to the player (asks which dictionary to use, prints out rules, prints out info up&until win/lose, 
 *                     asks player if he wants a rematch )
 * 
 * runs the game according to player input
 *                     
 */

public class Main {
    public static void main(String[] args){
        String path = "engl.txt"; // name and relative path of the dictionary file - default is English
        String input = ""; //initial empty string for user input
        char inputChar = '\n'; //initial char for user input (input will be converted to char)
        int playCounter = 1; //count how many times the player has played
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
                
        System.out.println("Welcome!");
        // ask the user which dictionary to use, then get it from WordGenerator class
        System.out.println("Would you like to guess English or German words? ");
        System.out.println("Type 'e' + Enter for English, or 'g' + Enter for German:");
        input = sc.nextLine();
        
        if (input.length()==1 && input.toLowerCase().charAt(0)=='e'){
            System.out.println("OK, English it is.");
        } else if(input.length()==1 && input.toLowerCase().charAt(0)=='g'){
            path = "germ.txt";
            System.out.println("OK, German it is.");
        } else { System.out.println("Invalid input. I'll default to English."); }
        
        WordGenerator wgen = new WordGenerator();
        final ArrayList<String> dictionary = wgen.readFile(path); // dictionary that will be used for the rest of the game runtime
        
        System.out.println("");
        System.out.println("Let's play!");
        System.out.println("I've chosen a word for you to guess. You will only need the standard alphabet, and the game is not case sensitive.");
        System.out.println("You can try to guess a single letter in the word - if the word contains it, it will be displayed. If not, a new piece"); 
        System.out.println("of the hangman drawing will appear (there are 8 of those in total), and if the drawing is completed, you lose."); 
        System.out.println("Or you can try to guess the whole word, but if you get it wrong, you lose."); 
        System.out.println("Try to guess the word:"); 
        
        //call on the actual game
        String word = wgen.chooseWord(dictionary); // the secret word player needs to guess in order to win
        GuessHandling gh = new GuessHandling(word,word.length());
        //System.out.println(word);
        gh.handleGuesses();
        //ask player for another go:
        while(true){
            System.out.println("Wanna play again?");
            do{
                System.out.println("Enter \"y\" for yes, or \"n\" for no:");
                input = sc.nextLine();
                inputChar = '\n';
                if (input.length()==1 && input.toLowerCase().charAt(0)=='y'){inputChar='y';}
                if(input.length()==1 && input.toLowerCase().charAt(0)=='n'){inputChar='n';}
            } while(inputChar == '\n');
            if(inputChar == 'n'){
            System.out.println("OK. thanks for playing!");
            break;
            } else {
            //give notice if this is the last time player can play:
            if(playCounter == 19){System.out.println("Alright, but you've played 19 times already - you can play one more time, \n and then back to your work! OK?");}
            //continue playing...
            System.out.println("OK. Try to guess this word:");
            //call on the actual game
            word = wgen.chooseWord(dictionary);
            GuessHandling guessh = new GuessHandling(word,word.length());
            //System.out.println(word);
            guessh.handleGuesses();
            //increase counter of times game was played:
            playCounter += 1;
            //if the game has already been played 20 times, force-stop the player
            if(playCounter == 20){ break; }
            }

        }    
    }

}
