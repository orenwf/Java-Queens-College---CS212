import javax.swing.*;
import java.awt.*;
/**  WordGUI objects are using in Project3.java to display the contents of a linked list; member methods for setting up GUI after instantiation and appending a sorted and unsorted linked list to WordGUI TextAreas in grid layout.  */

public class WordGUI extends JFrame {
	private static final long serialVersionUID = 1L;
    
    Container cPane;
    TextArea unsorted, sorted;

	public WordGUI () {

	}
		
	public void initialize() {
	      setLayout(new GridLayout(1,2));
	      setSize(400,400);
	      setLocation(200, 200);
	      setTitle("The Word GUI Project Pane");
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }	

	public void dataToGUI(WordList unsortedWords, WordList sortedWords) {
        cPane = getContentPane();
		unsorted = new TextArea();
		sorted = new TextArea();
		cPane.add(unsorted);
		cPane.add(sorted);
		unsortedWords.resetList(); // reset iterator for WordList
		for(int i=1; i<=unsortedWords.getListLength(); i++) { // append method from WordList
			unsorted.append(unsortedWords.nextWord().getWord()+"\n");
		}
		sortedWords.resetList();
		for(int i=1; i<=sortedWords.getListLength(); i++) {
			sorted.append(sortedWords.nextWord().getWord()+"\n");
		}
		pack();
		setVisible(true);
	}
	
}
