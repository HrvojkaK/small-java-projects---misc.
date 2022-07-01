import java.util.*;
import java.io.*;
/**
 * reads all the words from the dictionary passed in (readFile method)
 * 
 * chooses a random word from this dictionary and returns it (chooseWord mwthod), 
 * and keeps track of the words already used (stores them in 'usedWords' set)
 * 
 */
public class WordGenerator {
    //keep tabs on already used words:
    HashSet<String> usedWords;
    
    public WordGenerator(){
        usedWords = new HashSet<String>();
    }
    
    public ArrayList<String> readFile(String path) {
      //String path = "engl.txt"; // example of name and relative path of the dictionary file
      String line;
      ArrayList<String> dictionary = new ArrayList<String>();  
      
      try {
         BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                dictionary.add(line.toUpperCase());            
            }
         br.close();  
      } catch (Exception e) {
                        System.out.println("Caught exception: " + e);
      }
      return dictionary;
    }
    
    public String chooseWord(ArrayList<String> dictionary){
        // generate a random number for the index, 
        // then choose a random word that wasn't already used
        Random rndm = new Random();
        String chosenWord="";
        do{
            int rndmNumber = rndm.nextInt(dictionary.size());
            chosenWord = dictionary.get(rndmNumber).toUpperCase();
        }
        while(usedWords.contains(chosenWord));
        //add the chosen word to the set 
        usedWords.add(chosenWord);
        return chosenWord;
    }
}
