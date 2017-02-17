import javax.swing.*; // import JOptionPane class
public class Project0 {
/*Oren Friedman
 *Lab Section 11a
 */
  public static void main(String[] args) {
    String inputSentence;
    boolean runWhileTrue = true;
    int upperCase, lowerCase = 0;

    while(runWhileTrue) { // Program will run repeatedly until stop is entered as inputSentence

      inputSentence = JOptionPane.showInputDialog(null,"Enter a sentence to be processed."); //This section asks for users input in a popup window

      if(inputSentence.equalsIgnoreCase("STOP")) System.exit(0); //checks if user wants to end the program

      upperCase = findChars(inputSentence, 'E'); //sets local variables based on the number of occurrences of a char argument within String argument using findChars method
      lowerCase = findChars(inputSentence, 'e');

      JOptionPane.showMessageDialog(null,"The number of lower case e's: " +lowerCase +"\nThe number of upper case E's: " +upperCase); // provides the result to user

    }//end while loop

  } // end main method

  public static int findChars(String inptSntnc, char x) {   // This method counts up the number of occurrences of char parameter within String parameter
    int count = 0;
    for(int i = 0; i < inptSntnc.length(); i++)
      if(inptSntnc.charAt(i)==x) count++; // loop searches String for occurences of char and increments local variable

    return count;
  } // end findChars method

} // end class Project0
