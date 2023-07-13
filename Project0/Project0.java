// Name : Nasif Karim
// Lab Section : CSCI 212 11b

import javax.swing.*;
public class Project0 {
    public static void main(String[] args) {
        while (true) {
            // The loop is infinite until user inputs "Stop" or presses the x on the message panel
            String sentence;
            sentence = JOptionPane.showInputDialog(null, "Please enter a sentence.");
            // Prompts the user to enter a sentence
            if (sentence.equalsIgnoreCase("Stop")) {
                JOptionPane.showMessageDialog(null, "Shut Down");
                System.exit(0);
            } // if Stop is entered the program shuts down
            int upperCaseE = 0, lowerCaseE = 0;
            // The two variables are initialized to 0
            // They are counters for how many times lowercase and uppercase E appears
            for (int i = 0; i < sentence.length(); i++) { //for loop goes through the length of the sentence user inputs
                if (sentence.charAt(i) == 'e')
                    lowerCaseE++; // if lowercase E is found then the counter increments by one
                if (sentence.charAt(i) == 'E')
                    upperCaseE++; // if uppercase E is found then the counter increments by one
            }
            JOptionPane.showMessageDialog(null, "Number of lowercase e's: " + lowerCaseE +
                    "\n" + "Number of uppercase e's: " + upperCaseE);
            // Outputs the number of lowercase and uppercase E's that appears in the sentence
        }
    } // main
} // class Project0