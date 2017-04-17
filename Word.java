import java.util.*;
/** Word Class is a wrapper for strings; its methods allow for plain text file input to a linked list.*/
public class Word {
	
	static int WORD_SIZE = 3;
	String theWord;
	
	public Word(String s) {
		if(!isValidWord(s))
			throw new IllegalWordException(s+" is an invalid word. \n");
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
	
}
