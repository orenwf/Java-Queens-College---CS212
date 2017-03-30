import java.awt.*;
import javax.swing.JFrame;
public class Project2 {

	static WordGUI myGUI;
	static Container cPane;
	static TextArea sorted, unsorted;
	
	public static void main(String args[]) {
		initialize();
		WordList theWords, sortedWords;
		theWords = Word.makeWordList(args[0]);
		sortedWords = Word.makeSortedList(args[0]);
	// get input from text file and put in an array	of strings
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
	
	public static void dataToGUI(WordList unsortedWords, WordList sortedWords) {
		cPane = myGUI.getContentPane();
		unsorted = new TextArea();
		sorted = new TextArea();
		cPane.add(unsorted);
		cPane.add(sorted);
		unsortedWords.resetList();
		for(int i=1; i<=unsortedWords.getListLength(); i++) {
			unsorted.append(unsortedWords.nextWord().getWord()+"\n");
		}
		sortedWords.resetList();
		for(int i=1; i<=sortedWords.getListLength(); i++) {
			sorted.append(sortedWords.nextWord().getWord()+"\n");
		}
		myGUI.pack();
		myGUI.setVisible(true);
	}
}
