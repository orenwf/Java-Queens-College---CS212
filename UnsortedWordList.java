import java.util.*;
/** Unsorted WordList extends the abstract class WordList and has one member method to add to the list*/
public class UnsortedWordList extends WordList {

    public UnsortedWordList(){
        
        super();
    }
	
	// method to fill List of Words from text file from main class args
	public static UnsortedWordList makeUnsortedList(String myFile) {
		UnsortedWordList theList = new UnsortedWordList();
		TextFileInput in;
		String inputLine;
		StringTokenizer lineIn;
		
		// will try to assign tokens to Word objects and put in Word List
		//if illegal argument will move to the next token
				
		in = new TextFileInput(myFile);
		inputLine = in.readLine();
		while(inputLine!=null) {
			lineIn = new StringTokenizer(inputLine, ",");
			while(lineIn.hasMoreTokens()) {
				try {
					WordNode inputNode = new WordNode(new Word(lineIn.nextToken()));
					theList.add(inputNode);
				}
				catch(IllegalWordException iwe) {  
					System.out.println(iwe.getMessage()); // prints exception message to console
				}
			}
			inputLine = in.readLine();			
		}
		in.close();
		
		return theList;
	}

    
    public void add (WordNode x) {
		last.next = x;
		last = x;
		length++;
	}


}
