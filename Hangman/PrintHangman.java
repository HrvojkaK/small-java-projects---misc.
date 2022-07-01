
/**
 * this prints the hangman image in all of the stages 
 * (from just the rope - first wrong guess, to the complete drawing - for 8 wrong guesses) 
 * 
 * 
 */
public class PrintHangman {
    static void whiteSpace(){
        //this is just to visually clear the screen: 200 empty lines
        for (int i=0; i<200; i++){
            System.out.println("");
        }
    }
    
    public void drawing(int numOfGuesses){
        // print the corresponding image:
        // start with some white space first for better visuals
        whiteSpace();
              
        switch (numOfGuesses){
            case 1:
                System.out.println("    +---------+         ");
                System.out.println("    |         |         "); 
                System.out.println("    |                   ");
                System.out.println("    |                   ");
                System.out.println("    |                   ");
                System.out.println("    |                   ");
                System.out.println("    |                   ");
                System.out.println("===================     "); 
                System.out.println("");
                System.out.println("That was a bad guess."); 
                break;
            case 2:  
                System.out.println("    +---------+         ");
                System.out.println("    |         |         "); 
                System.out.println("    |         O         ");
                System.out.println("    |                   ");
                System.out.println("    |                   ");
                System.out.println("    |                   ");
                System.out.println("    |                   ");
                System.out.println("===================     ");
                System.out.println("");
                System.out.println("That was a bad guess."); 
                break;
            case 3:  
                System.out.println("    +---------+         ");
                System.out.println("    |         |         "); 
                System.out.println("    |         O         ");
                System.out.println("    |         |         ");
                System.out.println("    |                   ");
                System.out.println("    |                   ");
                System.out.println("    |                   ");
                System.out.println("===================     "); 
                System.out.println("");
                System.out.println("That was a bad guess."); 
                break;
            case 4:  
                System.out.println("    +---------+         ");
                System.out.println("    |         |         "); 
                System.out.println("    |         O         ");
                System.out.println("    |        /|         ");
                System.out.println("    |                   ");
                System.out.println("    |                   ");
                System.out.println("    |                   ");
                System.out.println("===================     "); 
                System.out.println("");
                System.out.println("That was a bad guess."); 
                break;
            case 5:  
                System.out.println("    +---------+         ");
                System.out.println("    |         |         "); 
                System.out.println("    |         O         ");
                System.out.println("    |        /|\\       ");
                System.out.println("    |                   ");
                System.out.println("    |                   ");
                System.out.println("    |                   ");
                System.out.println("===================     "); 
                System.out.println("");
                System.out.println("That was a bad guess."); 
                break;   
            case 6:  
                System.out.println("    +---------+         ");
                System.out.println("    |         |         "); 
                System.out.println("    |         O         ");
                System.out.println("    |        /|\\       ");
                System.out.println("    |         |         ");
                System.out.println("    |                   ");
                System.out.println("    |                   ");
                System.out.println("===================     ");
                System.out.println("");
                System.out.println("That was a bad guess."); 
                break;   
            case 7:  
                System.out.println("    +---------+         ");
                System.out.println("    |         |         "); 
                System.out.println("    |         O         ");
                System.out.println("    |        /|\\       ");
                System.out.println("    |         |         ");
                System.out.println("    |        /          ");
                System.out.println("    |                   ");
                System.out.println("===================     "); 
                System.out.println("");
                System.out.println("That was a bad guess.");                
                break;  
            case 8:  
                System.out.println("    +---------+         ");
                System.out.println("    |         |         "); 
                System.out.println("    |         O         ");
                System.out.println("    |        /|\\       ");
                System.out.println("    |         |         ");
                System.out.println("    |        / \\       ");
                System.out.println("    |                   ");
                System.out.println("===================     "); 
                System.out.println("");
                System.out.println("Sorry, you lost.");
                break;    
        }
        //add some white space bewlow the drawing
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

}
