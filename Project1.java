import java.awt.*;
import javax.swing.*;
public class Project1 {
	
	static WordGUI myGUI;
	static Container cPane;
	static TextArea sorted, unsorted;
	
	public static void main(String args[]) {
		Word[] theWords, theWordsToBeSorted, sortedWords;
		initialize();		
	// get input from text file and put in an array	of strings
		theWords = Word.fillArray(args[0]);
		int count = theWords.length;
		theWordsToBeSorted = Word.copyWordArray(theWords, count);
		sortedWords = Word.sSort(theWordsToBeSorted);
		dataToGUI(theWords, sortedWords);
	}
	
	public static void initialize() {
	      sorted = new TextArea();
	      unsorted = new TextArea();
	      myGUI=new WordGUI();
	      myGUI.setLayout(new GridLayout(1,2));
	      myGUI.setSize(400,400);
	      myGUI.setLocation(200, 200);
	      myGUI.setTitle("The Word GUI Project Pane");
	      myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   }	
	
	public static void dataToGUI(Word[] unsortedWords, Word[] sortedWords) {
		cPane = myGUI.getContentPane();
		unsorted = new TextArea();
		sorted = new TextArea();
		cPane.add(unsorted);
		cPane.add(sorted);
		for(int i = 0; i < unsortedWords.length; i++) {
			unsorted.append(unsortedWords[i].getWord()+"\n");
			sorted.append(sortedWords[i].getWord()+"\n");
		}
		myGUI.pack();
		myGUI.setVisible(true);
	}
}