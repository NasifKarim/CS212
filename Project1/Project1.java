// Nasif Karim
// CSCI 212 11B

import java.util.StringTokenizer; // importing StringTokenizer Class

public class Project1 {
    public static void main(String[] args) {
        String filename = new String("input.txt"); // creates a new String variable called filename that contains name of input file
        TextFileInput input = new TextFileInput(filename); // creates a new TextFileInput object called input that reads the input file
        String line = input.readLine(); // reads the first line of the input file into String variable called line
        StringTokenizer Roman; // declares a StringTokenizer variable called Roman
        Roman = new StringTokenizer(line, ",");// creates new StringTokenizer object and tokenizes the first line of input file using comma delimiter
        String Numeral[] = new String[100]; // creates new String Array called Numeral with a size of 100
        int i = 0; // initializes an integer variable called i to 0
        while (line != null) { // creates while loop and it keeps going as long as the line does not equal to null
            while (Roman.hasMoreTokens()) { // it is a nested while loop and if StringTokenizer Roman has more tokens, it keeps continuing
                Numeral[i] = Roman.nextToken(); // if both while loops conditions meet, the element i of Numeral array is set to next token from the Roman StringTokenizer object
                i++; // i is incremented by 1
            }
            line = input.readLine(); // reads the next line of the input file into the variable line
            if (line != null) { // checks if line does not equal to null
                Roman = new StringTokenizer(line, ","); // if conditions meet then creates new Roman StringTokenizer object and tokenizes the current line of the input file
            } else break; // ends the loops if the line is equal to null
        }
        String Value[] = new String[i]; // new string array is created called Value with a size equal to the final value of the variable i
        for (int j = 0; j < i; j++) { // for loop that iterates from 0 to the final value of i
            Value[j] = Integer.toString(valueOf(Numeral[j])); // the element j from Value array is set to the element j of Numeral array and converted to a string
        }

        RomanNumeralGUI romanGUI = new RomanNumeralGUI(Value, Numeral); // creates a new RomanNumeralGui object called romanGui and it takes Value and Numeral arrays as arguments

    } // close main

    public static int valueOf(String romanNumeral) { //this method converts a Roman numeral to an Arabic numeral and is called valueOf and it takes String romanNumeral as an argument

        int arabicNumeral = 0; // initializes the variable to hold the Arabic numeral value
        for (int i = 0; i < romanNumeral.length(); i++) { // for loop that iterates through each character in the Roman numeral
            char current = romanNumeral.charAt(i); // char current gets the current character in the Roman numeral
            int currentValue = getValue(current);  // integer current value gets the value of the current character

            if (i + 1 < romanNumeral.length()) { // checks if there is a next character in the Roman numeral
                char next = romanNumeral.charAt(i + 1); // if the conditions meet,then gets the next character in the Roman numeral
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

    } // close valueOf
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


} // close class



