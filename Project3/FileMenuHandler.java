import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.StringTokenizer;

/**
 * Handles the File menu events in the application
 * Opens a file, reads the contents of the file and displays it in three columns
 * Quits the program when "Quit" is pressed
 *
 * @author N.Karim
 */

public class FileMenuHandler implements ActionListener {
    JFrame jframe;

    /**
     * Constructs a new FileMenuHandler object with a JFrame parameter
     *
     * @param jf a JFrame object to be used to display the result
     */
    public FileMenuHandler(JFrame jf) {
        jframe = jf;
    } // constructor

    /**
     * Handles the action events from the file menu items
     *
     * @param event the event to be processed
     */
    public void actionPerformed(ActionEvent event) {
        String menuName;
        menuName = event.getActionCommand();
        if (menuName.equals("Open")) // if clicked open, display file chooser
            openFile(); // prompts user to choose file to read from
        else if (menuName.equals("Quit"))
            System.exit(0); // if clicked quit, quit the program
    }

    /**
     * Opens the file chooser dialog and reads the selected input file
     */
    private void openFile() {
        int status;
        JFileChooser chooser = new JFileChooser(); // creates a JFileChooser object for the user to select a file
        status = chooser.showOpenDialog(null); // opens file choose dialog and returns status of user action
        if (status == JFileChooser.APPROVE_OPTION) { // if the user approves file selection
            readSource(chooser.getSelectedFile()); // read the selected input file
        } else
            JOptionPane.showMessageDialog(null, "Open File dialog cancelled"); // displays a message dialog if the user cancels the file selection
    }

    /**
     * reads the input file and displays the Roman numerals with the sorted and unsorted arabic values
     *
     * @param chosenFile the File object representing the selected input file
     */
    private void readSource(File chosenFile) {

        String chosenFileName = chosenFile.getAbsolutePath(); // get the absolute path of the chosen file and stores it in chosenFileName
        TextFileInput input = new TextFileInput(chosenFileName); // creates a new TextFileInput object called input with chosenFile as an argument
        UnsortedRomanNumeralList unsorted = new UnsortedRomanNumeralList(); // creates a new UnsortedRomanNumeralList object called unsorted
        SortedRomanNumeralList sort = new SortedRomanNumeralList(); // creates a new SortedRomanNumeralList object called sorted
        String line = input.readLine(); // reads the first line of the input file into String variable called line
        StringTokenizer Roman; // declares a StringTokenizer variable called Roman
        Roman = new StringTokenizer(line, ",");// creates new StringTokenizer object and tokenizes the first line of input file using comma delimiter
        jframe.getContentPane().removeAll(); // removes the previous display when new file is opened
        String inputs = ""; // string variable called inputs is initialized to empty string
        String StoreArabicNum = ""; // string variable StoreArabicNum is initialized to empty string

        while (line != null) { // creates while loop and it keeps going as long as the line does not equal to null
            while (Roman.hasMoreTokens()) {// it is a nested while loop and if StringTokenizer Roman has more tokens, it keeps continuing
                try {
                    StoreArabicNum = Roman.nextToken(); // gets the next token from Roman tokenizer and stores it in StoreArabicNum variable
                    RomanNumeral romanNumeral = new RomanNumeral(StoreArabicNum); // creates a new RomanNumeral object with the value from StoreArabicNum as an argument
                    inputs += StoreArabicNum + "\n"; // appends the StoreArabicNum value and separate lines to inputs string
                    unsorted.append(romanNumeral); // adds the StoreArabicNum to the unsorted list
                    sort.add(romanNumeral); // adds the RomanNumeral object to the sorted list
                } catch (IllegalRomanNumeralException e) {
                    System.out.println(e); // prints error message
                }

            }

            line = input.readLine(); // reads the next line of the input file into the variable line
            if (line != null) { // checks if line does not equal to null
                Roman = new StringTokenizer(line, ","); // if conditions meet then creates new Roman StringTokenizer object and tokenizes the current line of the input file
            } else break; // ends the loops if the line is equal to null
        }
        Container myTextArea = jframe.getContentPane(); // gets the content pane of the JFrame
        myTextArea.setLayout(new GridLayout(1, 3)); // the layout of JFrame is 1x3 grid
        TextArea myNumeral = new TextArea(); // creates new TextArea object to display Roman Numerals
        TextArea myArabicUnsorted = new TextArea(); // creates new TextArea object to display unsorted Arabic numerals
        TextArea myArabicSorted = new TextArea(); // creates new TextArea object to display sorted Arabic numerals

        myNumeral.setText("Roman Numerals" + "\n"); // sets the title of the first column
        myNumeral.append(inputs); // appends the String inputs to myNumeral TextArea
        myTextArea.add(myNumeral); // adds the myNumeral to the content pane of the JFrame

        myArabicUnsorted.setText("Unsorted List" + "\n"); // sets the title of the second column
        myArabicUnsorted.append(unsorted.toString());  // append the unsorted list of Arabic numerals to myArabicUnsorted
        myTextArea.add(myArabicUnsorted); // adds the myArabicUnsorted to the content pane of the JFrame

        myArabicSorted.setText("Sorted List" + "\n"); // sets the title of the third column
        myArabicSorted.append(sort.toString()); // append the sorted list of Arabic numerals to myArabicSorted
        myTextArea.add(myArabicSorted); // adds the myArabicSorted to the content pane of the JFrame

        jframe.setVisible(true); // sets jframe to be visible


    }

}
