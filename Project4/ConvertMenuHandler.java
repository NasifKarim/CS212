import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles the conversion of a Roman numeral to Arabic numeral
 *
 * @author N. Karim
 */

public class ConvertMenuHandler implements ActionListener {
    RomanNumeralGUI rnGUI;

    /**
     * Constructs a new ConvertMenuHandler object with RomanNumeralGui parameter
     *
     * @param rn the RomanNumeralGUI object
     */
    public ConvertMenuHandler(RomanNumeralGUI rn) {
        rnGUI = rn;
    }

    /**
     * When "Convert" menu is selected, it prompts the user to enter a Roman Numeral
     * Displays the converted Roman Numeral value to arabic value in a message box
     * If Roman numeral is not valid, it displays error message
     *
     * @param event the event to be processed
     * @throws IllegalRomanNumeralException if the Roman numeral entered is not valid
     */

    public void actionPerformed(ActionEvent event) {
        try {
            String input = JOptionPane.showInputDialog(null, "Enter a Roman Numeral to convert :"); // prompts the user to enter a Roman numeral
            RomanNumeral rn = new RomanNumeral(input); // converts input to arabic value
            JOptionPane.showMessageDialog(null, "The Arabic value of the Roman Numeral you entered is " + rn.getArabic()); // displays the arabic value of the roman numeral

        } catch (IllegalRomanNumeralException e) {
            JOptionPane.showMessageDialog(null, "Your Roman Numeral is not valid "); // displays the error message if roman numeral entered is not valid
            throw e; // throw IllegalRomanNumeralException
        }

    }

}

