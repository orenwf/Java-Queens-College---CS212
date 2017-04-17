import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;

/**
  * Class handles events from the WordGUI menu class
  */

public class FileMenuHandler implements ActionListener {

	private WordGUI theGUI;
    public FileMenuHandler(WordGUI mwg) {
        theGUI = mwg;
    }

// Listens for clicks on the two File menu items
	public void actionPerformed(ActionEvent event){
    	String menuName = event.getActionCommand();
    	if(menuName.equals("Open"))
        	openFile(); // file chooser goes here
    	else if(menuName.equals("Quit")) // this will quit the program
        	System.exit(0);
	} 

//will open the chooser to pass a file back to be read
	public void openFile() {
  		int status;
  		JFileChooser chooser = new JFileChooser( );
  		status = chooser.showOpenDialog(null);
  		readSource(chooser.getSelectedFile());
	}
// reads the selected file and puts the contents into WordList objects	
	public void readSource(File inputFile){
		String fileName = inputFile.getName();
		UnsortedWordList theWords;
        SortedWordList sortedWords;
    	// get input from text file and put the words that are valid Word type in a linked list
		theWords = UnsortedWordList.make(fileName);
		sortedWords = SortedWordList.make(fileName);
		theGUI.dataToGUI(theWords, sortedWords);
	}

}
