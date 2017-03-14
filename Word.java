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
	
	public static Word[] copyWordArray(Word[] array, int length) { //method to copy a Word array to a new word array
		Word[] copied = new Word[length];
		for(int i=0; i<length; i++) copied[i] = new Word(array[i].getWord());
		return copied;
	}
	
	// selection sort method for array of Word objects
	public static Word[] sSort(Word[] unsortedArray) {
		int count = unsortedArray.length;
		Word[] sortedArray;
		sortedArray = new Word[count];
		int min; // index position of lexicographically minimum word in unsorted portion of array
		for(int l = 0; l < count; l++) {
			min = l;
			for(int i =l+1; i < count; i++) //find array position of the lexicographically minimum word
				if(unsortedArray[i].getWord().compareTo(unsortedArray[min].getWord())<0) min = i;
			swap(unsortedArray[l], unsortedArray[min]); // swap the lexicographically minimum word with lowest unsorted array position
		}
		sortedArray = unsortedArray;
		return sortedArray;
	}

	// basic swap function for elements within Word array
	private static void swap(Word first, Word second) {
		Word temp = new Word(first.getWord());
		first.setWord(second.getWord());
		second.setWord(temp.getWord());
	}
	
		
	// method to fill Array of Words from text file from main class args
	public static Word[] fillArray(String myFile) {
		Word[] theArray;
		int arraySize = 0;
		TextFileInput in;
		String inputLine;
		StringTokenizer lineIn;
		
		//will count the tokens and increment arraySize to the appropriate size	based on the text file
		in = new TextFileInput(myFile);
		inputLine = in.readLine();
		while(inputLine!=null) {
			lineIn = new StringTokenizer(inputLine, ",");
			arraySize+=lineIn.countTokens();
			inputLine = in.readLine();
		}
		in.close();
		theArray = new Word[arraySize];

		// will try to assign tokens to Word objects within array
		//if illegal argument will move to the next token
		// there will be some number of null array values based on the number of invalid words skipped
		// we will keep track of number of valid words and copy over the valid words to a correctly sized array
		int arrayIndex = 0;	//for keeping track of position in filling theArray
		int correctedArraySize = arraySize; // for keeping track of the final correct size of the array
				
		in = new TextFileInput(myFile);
		inputLine = in.readLine();
		while(inputLine!=null) {
			lineIn = new StringTokenizer(inputLine, ",");
			while(lineIn.hasMoreTokens()) {
				try {
					theArray[arrayIndex]= new Word(lineIn.nextToken());
					arrayIndex++;
				}
				catch(IllegalArgumentException iae) {  
					System.out.println(iae.getMessage()); // prints exception message to console
					correctedArraySize--; // decrements because we have skipped an invalid word
				}
			}
			inputLine = in.readLine();			
		}
		in.close();
		
		//we will now copy the contents of the theArray which are not null to correctedArray
		Word[] correctedArray;
		correctedArray = copyWordArray(theArray, correctedArraySize);
		return correctedArray;
	}
}