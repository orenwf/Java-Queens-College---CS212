import java.awt.*;
import javax.swing.*;
public class Project3 {

	public static void main(String args[]) {
		WordGUI myGUI = new WordGUI();
        myGUI.initialize();
		WordList theWords, sortedWords;
		theWords = Word.makeWordList(args[0]);
		sortedWords = Word.makeSortedList(args[0]);
	// get input from text file and put in an array	of strings
		myGUI.dataToGUI(theWords, sortedWords);
	}
	
}
