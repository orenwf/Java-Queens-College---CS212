import java.awt.*;
import javax.swing.*;
/**Project 3 uses a number of classes for reading text to a GUI. */
public class Project3 {

	public static void main(String args[]) {
		WordGUI myGUI = new WordGUI();
		UnsortedWordList theWords;
        SortedWordList sortedWords;
    	// get input from text file and put the words that are valid Word type in a linked list
		theWords = UnsortedWordList.make(args[0]);
		sortedWords = SortedWordList.make(args[0]);
		myGUI.dataToGUI(theWords, sortedWords);// display words in an unsorted list and a sorted list in GUI
	}
	
}
