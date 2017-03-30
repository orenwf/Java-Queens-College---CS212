import java.util.*;
public class Word {
	
	static int WORD_SIZE = 3;
	String theWord;
	
	public Word(String s) {
		if(!isValidWord(s))
			throw new IllegalArgumentException(s+" is an invalid word. \n");
		else theWord = s;
	}
	
	public void setWord(String s) {
		theWord = s;
	}
	
	public String getWord() {
		return theWord;
	}
	
	private static boolean isValidWord(String s) { //checks for valid word based on static class variable
		if(s.length() != WORD_SIZE) return false;
		return true;
	}
	
	// method to fill List of Words from text file from main class args
	public static WordList makeWordList(String myFile) {
		WordList theList = new WordList();
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
					theList.append(inputNode);
				}
				catch(IllegalArgumentException iae) {  
					System.out.println(iae.getMessage()); // prints exception message to console
				}
			}
			inputLine = in.readLine();			
		}
		in.close();
		
		return theList;
	}
	
	// method to fill List of Words from text file in alphabetical order
	public static WordList makeSortedList(String myFile) {
		WordList theList = new WordList();
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
					theList.insert(inputNode); // inserts instead of appends by WordList method
				}
				catch(IllegalArgumentException iae) {  
					System.out.println(iae.getMessage()); // prints exception message to console
				}
			}
			inputLine = in.readLine();			
		}
		in.close();
		
		return theList;
	}
	
}