import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ConvertMenuHandler implements ActionListener {
    RomanNumeralGUI rnGUI;

    public ConvertMenuHandler (RomanNumeralGUI rn) {
        rnGUI = rn;
    }

    public void actionPerformed(ActionEvent event) {
        String menuName;
        String input = null;
        menuName = event.getActionCommand ();
        if (menuName.equals ("Roman to Arabic"))
            input = JOptionPane.showInputDialog(null, "Enter a Roman Numeral to convert :");
                int result = convertToArabic(input);
                JOptionPane.showMessageDialog(null, "The Arabic value of the Roman Numeral you entered is " + convertToArabic(input));




    }

    public int convertToArabic(String roman) {
        int arabicNumeral = 0; // initializes the variable to hold the Arabic numeral value
        for (int i = 0; i < roman.length(); i++) { // for loop that iterates through each character in the Roman numeral
            char current = roman.charAt(i); // char current gets the current character in the Roman numeral
            int currentValue = getValue(current);  // integer current value gets the value of the current character

            if (i + 1 < roman.length()) { // checks if there is a next character in the Roman numeral
                char next = roman.charAt(i + 1); // if the conditions meet,then gets the next character in the Roman numeral
                int nextValue = getValue(next); // integer nextValue get the value of the next character and stores it

                if (currentValue < nextValue) { //checks if the current value is less than the next value
                    arabicNumeral -= currentValue;// if conditions meet,subtract the current value from the Arabic numeral

                } else {
                    arabicNumeral += currentValue; //  // if it is not, add the current value to the Arabic numeral
                }
            } else {
                arabicNumeral += currentValue; // if there is no next character, add the current value to the Arabic numeral

            }
        }
        return arabicNumeral;// returns the Arabic numeral value

    }

    public static int getValue(char romanNumeral) { // this method takes character romanNumeral as an argument and pairs each Roman Numeral with its Arabic Numeral
        if (romanNumeral == 'I') {
            return 1; // romanNumeral I is equal to 1
        } else if (romanNumeral == 'V') {
            return 5; // romanNumeral V is equal to 5
        } else if (romanNumeral == 'X') {
            return 10; // romanNumeral X is equal to 10
        } else if (romanNumeral == 'L') {
            return 50; // romanNumeral L is equal to 50
        } else if (romanNumeral == 'C') {
            return 100; // romanNumeral C is equal to 100
        } else if (romanNumeral == 'D') {
            return 500; // romanNumeral D is equal to 500
        } else if (romanNumeral == 'M') {
            return 1000; // romanNumeral M is equal to 1000
        } else {
            return 0; // if none of the conditions above are met then return 0
        }
    } // close getValue

    private void readSource (File chosenFile) {
        String chosenFileName = chosenFile.getAbsolutePath();
        TextFileInput inFile = new TextFileInput (chosenFileName);
        String inputLine;
        int subscript = 0;
        Container myContentPane = rnGUI.getContentPane();
        JTextArea myTextArea = new JTextArea();
        JTextArea mySubscripts = new JTextArea();
        myContentPane.add (myTextArea, BorderLayout.EAST);
        myContentPane.add(mySubscripts, BorderLayout.WEST);
        inputLine = inFile.readLine();
        while (inputLine != null) {
            mySubscripts.append(Integer.toString(subscript++) + "\n");
            myTextArea.append (inputLine + "\n");
        }
        rnGUI.setVisible(true);
    }

}
