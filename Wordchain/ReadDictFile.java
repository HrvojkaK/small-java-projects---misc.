import java.util.*;
import java.io.*;
/**
 * reads all the words from "spanish.txt" - this file 
 * contains words with more than 3 letters
 * 
 * a map is created, where the keys are the first 2 letters of words from the file, 
 * and values are sets of words that begin with these two letters
 * 
 */
public class ReadDictFile {
    
    public HashMap<String, Set<String>> dictionary;
    
    public ReadDictFile(){
        dictionary = new HashMap<>();
    }
       
    public HashMap<String, Set<String>> makeDict() {
      String path = "spanish.txt"; //name and relative path of the dictionary file
      String line;

      try {
         BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                //dictionary.add(line.toUpperCase());
                Set<String> val = dictionary.get(line.substring(0,2));
                if (val == null) { //if this key doesn't exist yet, add it and add the word in the values
                    val = new HashSet<>();
                    val.add(line);
                    dictionary.put(line.substring(0,2), val);
                }
                else {
                    val.add(line);
                }
            }
         br.close();  
      } catch (Exception e) {
          System.out.println("Caught exception: " + e);
      }
      return dictionary;
    }
    
}
