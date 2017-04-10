import java.util.*;
/** SortedWordList extends the abstract class WordList and has one member method to add words to the linked list in a sorted manner*/
public class SortedWordList extends WordList {
    
    public SortedWordList() {

        super();
    }
	
	// method to fill List of Words from text file in alphabetical order
	public static SortedWordList makeSortedList(String myFile) {
		SortedWordList theList = new SortedWordList();
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
					theList.add(inputNode); // inserts instead of appends by WordList method
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
		if(length==0) {
            last.next = x;
		    last = x;
    		length++;
            return;
		}
		WordNode c = new WordNode ();
		c = first.next;
		while(c.next!=null && x.data.getWord().compareToIgnoreCase(c.next.data.getWord())>0) { // moves through the list until x is lexicographically smaller or equal to c.next
			c=c.next;
		}
		x.next  = c.next;
		c.next = x;
		length++;
	}

}
