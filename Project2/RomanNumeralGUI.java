import java.awt.*;
import javax.swing.*;

/**
 * RomanNumeralGUI that extends JFrame class
 * @author N. Karim
 */

public class RomanNumeralGUI extends JFrame { // declares public class RomanNumeralGGUI that extends the JFrame class
    /**
     *
     * @param inputs
     * @param sort
     * @param unsorted
     */
    public RomanNumeralGUI(String inputs, RomanNumeralList sort, RomanNumeralList unsorted) { // RomenNumeralGUI class is declared as public constructor that takes String inputs,RomanNumeralList sort,and RomanNumeralList unsorted as arguments
        setTitle("Roman Numeral to Arabic Numeral"); // sets the title of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //if user press Close button then the program exit
        setSize(600, 500); // sets size of JFrame to 600x500 pixels
        createFileMenu ();
        createConvertMenu ();
        setLayout(new GridLayout(1, 3)); // the layout of JFrame is 1x3 grid
        setLocationRelativeTo(null); // sets location of JFrame to center of screen
        Container myTextArea = getContentPane(); // gets the content pane of the JFrame
        TextArea myNumeral = new TextArea(); // creates new TextArea object to display Roman Numerals
        TextArea myArabicUnsorted = new TextArea(); // creates new TextArea object to display unsorted Arabic numerals
        TextArea myArabicSorted = new TextArea(); // creates new TextArea object to display sorted Arabic numerals

        myNumeral.setText("Roman Numerals" + "\n"); // sets the title of the first column
        myNumeral.append(inputs); // appends the String inputs to myNumeral TextArea
        myTextArea.add(myNumeral); // adds the myNumeral to the content pane of the JFrame

        myArabicUnsorted.setText("Unsorted List" + "\n"); // sets the title of the first column
        myArabicUnsorted.append(unsorted.toString());  // append the unsorted list of Arabic numerals to myArabicUnsorted
        myTextArea.add(myArabicUnsorted); // adds the myArabicUnsorted to the content pane of the JFrame

        myArabicSorted.setText("Sorted List" + "\n"); // sets the title of the third column
        myArabicSorted.append(sort.toString()); // append the sorted list of Arabic numerals to myArabicSorted
        myTextArea.add(myArabicSorted); // adds the myArabicSorted to the content pane of the JFrame
        setVisible(true); // set the JFrame to be visible

    }

    private void createFileMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem item;
        FileMenuHandler fmh = new FileMenuHandler (this);
        item = new JMenuItem ("Open");
        item.addActionListener(fmh);
        fileMenu.add (item);
        item = new JMenuItem ("Quit");
        item.addActionListener(fmh);
        fileMenu.add(item);
        setJMenuBar(menuBar);
        menuBar.add(fileMenu); // put the fileMenu in the menuBar
       // setJMenuBar(menuBar); // put the menuBar in the JFrame

    }

    private void createConvertMenu () {
        JMenuBar menuBar = new JMenuBar();
        JMenu convertMenu = new JMenu("Convert");
        JMenuItem item;
        ConvertMenuHandler cmh = new ConvertMenuHandler (this);
        item = new JMenuItem ("Roman to Arabic");
        item.addActionListener(cmh);
        convertMenu.add (item);
        setJMenuBar(menuBar);
        menuBar.add(convertMenu); // put the fileMenu in the menuBar
       // setJMenuBar(menuBar);

    }
}