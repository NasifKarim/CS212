import javax.swing.*;

/**
 * The class extends JFrame and creates graphical user interface
 * When user runs program, it pops up
 * The class uses methods to create a menu bar, a file menu , and a convert menu
 *
 * @author N. Karim
 */
public class RomanNumeralGUI extends JFrame { // declares public class RomanNumeralGGUI that extends the JFrame class
    /**
     * Sets up the GUI
     * Creates menu bar with File menu and Convert menu
     */
    public RomanNumeralGUI() { // RomenNumeralGUI class is declared as public constructor that takes String inputs,RomanNumeralList sort,and RomanNumeralList unsorted as arguments
        setTitle("Roman Numeral to Arabic Numeral"); // sets the title of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //if user press Close button then the program exit
        setSize(600, 500); // sets size of JFrame to 600x500 pixels
        JMenuBar menuBar = new JMenuBar(); // creates a new JMenuBar object called menuBar
        createFileMenu(menuBar); // calls createFileMenu method and passes the menuBar as an argument to create the File menu
        createConvertMenu(menuBar); // calls createConvertMenu method and passes the menuBar as an argument to create the Convert menu
        setLocationRelativeTo(null); // sets location of JFrame to center of screen
        setVisible(true); // set the JFrame to be visible

    }

    /**
     * Creates a file menu with options to open and quit the program
     * Sets the file menu to the menu bar
     *
     * @param menuBar The JMenuBar object to which the file menu is added
     */
    private void createFileMenu(JMenuBar menuBar) {
        JMenu fileMenu = new JMenu("File"); // creates a new JMenu object called fileMenu with label "File"
        JMenuItem item; // declares a new JMenuItem object called item
        FileMenuHandler fmh = new FileMenuHandler(this);

        item = new JMenuItem("Open"); // creates a new JMenuItem object called item with label "Open"
        item.addActionListener(fmh); //adds fmh as an ActionListener for item
        fileMenu.add(item); //adds item to fileMenu

        item = new JMenuItem("Quit"); // creates a new JMenuItem object called item with label "Quit"
        item.addActionListener(fmh); // adds fmh as an ActionListener for item
        fileMenu.add(item);//adds item to fileMenu
        setJMenuBar(menuBar); //sets the menuBar as the JMenuBar for this JFrame
        menuBar.add(fileMenu); // adds the fileMenu to the menuBar

    }

    /**
     * Creates a convert menu with an option to convert Roman numerals to Arabic numerals
     * Sets the convert menu to the menu bar
     *
     * @param menuBar The JMenuBar object to which the convert menu is added
     */
    private void createConvertMenu(JMenuBar menuBar) {
        JMenu convertMenu = new JMenu("Convert"); // creates the convert menu
        JMenuItem item;
        ConvertMenuHandler cmh = new ConvertMenuHandler(this); // creates new ConvertMenuObject

        item = new JMenuItem("Roman to Arabic"); //creates a new JMenuItem object called item with label "Roman to Arabic"
        item.addActionListener(cmh);
        convertMenu.add(item); // Set the menu bar and add the "Convert" menu to it

        menuBar.add(convertMenu);
    }
}