import java.awt.*;
import javax.swing.JFrame;
public class RomanNumeralGUI extends JFrame { // declares public class RomanNumeralGGUI that extends the JFrame class
    RomanNumeralGUI(String Value[], String Numeral[]) { // RomenNumeralGUI class is declared as public constructor that takes String Value array and String Numeral Array as arguments
        setTitle("Roman Numeral to Arabic Numeral"); // sets title of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //if user press Close button then the program exit
        setSize(400, 400); // sets size of JFrame to 400x400 pixels
        setLayout(new GridLayout(1, 2)); // the layout of JFrame is 1x2 grid
        setLocationRelativeTo(null); // sets location of JFrame to center of screen
        Container myTextArea = getContentPane();// creates new container object to hold TextAreas
        TextArea myNumeral = new TextArea(); // creates new TextArea object to display Roman Numerals
        TextArea myArabic = new TextArea(); // creates new TextArea object to display Arabic numerals

        for (int i = 0; i < Value.length; i++) { // for loop iterates through each element in Value array
            myNumeral.append(Numeral[i] + "\n"); // appends current Roman numeral to myNumeral TextArea
            myArabic.append(Value[i] + "\n"); // appends current Arabic numeral to myArabic TextArea
        }

        myTextArea.add(myNumeral); // adds myNumeral TextArea to myTextArea container
        myTextArea.add(myArabic); // adds myArabic TextArea to myTextArea container
        setVisible(true); // sets JFrame visible
    } // close RomanNumeralGUI constructor
} // close class
