import javax.swing.*;
import java.awt.*;
/**  WordGUI objects are using in Project3.java to display the contents of a linked list; member methods for setting up GUI after instantiation and appending a sorted and unsorted linked list to WordGUI TextAreas in grid layout.  */

public class WordGUI extends JFrame {
	private static final long serialVersionUID = 1L;
    
    Container cPane;
    TextArea unsorted, sorted;

	public WordGUI () {
        setLayout(new GridLayout(1,2));
	    setSize(400,400);
	    setLocation(200, 200);
	    setTitle("The Word GUI Project Pane");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem item;
        FileMenuHandler fmh = new FileMenuHandler(this);
        item = new JMenuItem("Open");
        item.addActionListener(fmh);
        fileMenu.add(item);
        fileMenu.addSeparator();
        item = new JMenuItem("Quit");
        item.addActionListener(fmh);
        fileMenu.add(item);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
		cPane = getContentPane();
		unsorted = new TextArea();
		sorted = new TextArea();
		cPane.add(unsorted);
		cPane.add(sorted);
    }
		
	public void dataToGUI(WordList unsortedWords, WordList sortedWords) {
		unsorted.setText(null);
		sorted.setText(null);
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
