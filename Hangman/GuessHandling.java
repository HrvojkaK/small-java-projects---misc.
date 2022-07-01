import java.util.*;
/**
 * handles the game - takes player input, checks if it is a valid iput - if so, checks if
 * a good letter or word guess was made and prints the according information
 * 
 */
public class GuessHandling {
    int numOfWrongGuesses; //number of current wrong guesses - max allowed is 8!
    String secretWord; // this is the chosen word that player needs to guess
    int secretWordLen; //this is the length of the secretWord
    int numOfRevealed; //keeping track of the total number of revealed letters
    List<Character> currWord; //list of chars - current word guess (ex.initially ___, will update to CAT)
    Set<Character> triedChars; //store here the chars player tried
    PrintHangman ph = new PrintHangman(); //instantiate this for display of hangman drawings
    
    public GuessHandling(String secretWord, int secretWordLen){
        this.secretWord = secretWord;
        this.secretWordLen = secretWordLen;
        numOfWrongGuesses = 0; //start with 0 wrong guesses
        numOfRevealed = 0; //start with 0 revealed letters
        triedChars = new HashSet<Character>(); 
        //currWord = .... start with, say, ___ for CAT
        currWord = new ArrayList<Character>();
        for (int i=0; i<secretWordLen; i++){ currWord.add(i,'_'); }
    }
    
    public void printCurrWord(){
        //this just prints out the currWord (current secret word state) nicely
        for (int i = 0; i < secretWordLen; i++){ System.out.print(currWord.get(i).toString()); }
    }
    
    public void checkLetter(char c){
        //this will check if the letter player guessed is in the secretWord or not
        int firstIndex = -1; //initial value
        firstIndex = secretWord.indexOf(c); //if it doesn't contain it, it will return -1
        if (firstIndex == -1){
            //letter is not in the secretWord
            //update numOfWrongGuesses and print hangman
            numOfWrongGuesses = numOfWrongGuesses + 1;
            ph.drawing(numOfWrongGuesses);
        } else if (firstIndex >= 0){
            //secretWord contains letter - update and show it
            for (int indx = firstIndex; indx < secretWordLen; indx ++){
                //find all occurences of letter
                if (secretWord.charAt(indx) == c){ 
                    currWord.set(indx, c);
                    numOfRevealed = numOfRevealed + 1;
                }
            }
            System.out.println(c+" is a good guess.");
        }
        //add the char player guessed to the set of already tried chars
        triedChars.add(c);
    }
    
    public void handleGuesses(){
        String input;
        Scanner sc = new Scanner(System.in);  //Scanner object to read input
       
        //max number of allowed wrong guesses is 8 (8 pieces of the hangman drawing)
        while(numOfWrongGuesses < 9){
            //print what it is to be guessed:
            System.out.println("");
            printCurrWord(); 
            System.out.println("");

            System.out.println("Your guess:");
            input = sc.nextLine();
            //check if player has tried to guess the whole word:
        
            if (input.length()==secretWordLen && input.toUpperCase().equals(secretWord)){
                //player guessed it!
                System.out.println("YOU WON!");  
                System.out.println("");
                break;
            } else if (input.length()==secretWordLen && !input.toUpperCase().equals(secretWord)){
                //player guessed the wrong word and lost the game
                System.out.println("Sorry, that is not correct.");
                System.out.println("The right answer is: " + secretWord);
                System.out.println("You lost.");
                System.out.println("");
                break;
            } else if (input.length()==1 && Character.isLetter(input.charAt(0))){
                //player guessed a single letter - valid input
                //check if player already tried this char - if so, notify and move on:
                if(triedChars.contains(input.toUpperCase().charAt(0))){
                    PrintHangman.whiteSpace();
                    System.out.println("You already tried this letter!");
                } else{
                PrintHangman.whiteSpace();    
                //now check if this letter is in secretWord:
                char b = input.toUpperCase().charAt(0);
                checkLetter(b);
                
                  if(numOfWrongGuesses == 8){ 
                      System.out.println("The word was: "+secretWord);
                      break; }
                
                }
                if(numOfRevealed == secretWordLen){
                    System.out.println("YOU WON!");  
                System.out.println("");
                break;
                }
            } else {
                //none of the cases above - player entered an invalid input
                PrintHangman.whiteSpace();
                System.out.println("Please enter a valid guess (single letter or a word of appropriate length).");
                System.out.println("");
            }
  
        }
    }
}
