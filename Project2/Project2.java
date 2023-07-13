// Nasif Karim CSCI 212 11b
import java.util.StringTokenizer;

public class Project2 {
    public static void main(String[] args) {
        String filename = new String("input.txt"); // creates a new String variable called filename that contains name of input file
        TextFileInput input = new TextFileInput(filename); // creates a new TextFileInput object called input that reads the input file
        UnsortedRomanNumeralList unsorted = new UnsortedRomanNumeralList(); // creates a new UnsortedRomanNumeralList object called unsorted
        SortedRomanNumeralList sort = new SortedRomanNumeralList(); // creates a new SortedRomanNumeralList object called sorted
        String line = input.readLine(); // reads the first line of the input file into String variable called line
        StringTokenizer Roman; // declares a StringTokenizer variable called Roman
        Roman = new StringTokenizer(line, ",");// creates new StringTokenizer object and tokenizes the first line of input file using comma delimiter

        int i = 0; // initializes an integer variable called i to 0
        String inputs = ""; // string variable called inputs is initialized to empty string
        String StoreRoman = ""; // string variable StoreRoman is initialized to empty string
        String StoreArabicNum = ""; // string variable StoreArabicNum is initialized to empty string

        while (line != null) { // creates while loop and it keeps going as long as the line does not equal to null
            while (Roman.hasMoreTokens()) {// it is a nested while loop and if StringTokenizer Roman has more tokens, it keeps continuing
                StoreArabicNum = Roman.nextToken(); // gets the next token from Roman tokenizer and stores it in StoreArabicNum variable
                inputs += StoreArabicNum + "\n"; // appends the StoreArabicNum value and separate lines to inputs string
                RomanNumeral romanNumeral = new RomanNumeral(StoreArabicNum); // creates a new RomanNumeral object with the value from StoreArabicNum as an argument
                unsorted.append(romanNumeral); // adds the StoreArabicNum to the unsorted list
                sort.add(romanNumeral); // adds the RomanNumeral object to the sorted list
                i++; // i is incremented by 1
            }

            line = input.readLine(); // reads the next line of the input file into the variable line
            if (line != null) { // checks if line does not equal to null
                Roman = new StringTokenizer(line, ","); // if conditions meet then creates new Roman StringTokenizer object and tokenizes the current line of the input file
            } else break; // ends the loops if the line is equal to null
        }

        RomanNumeralGUI romanGUI = new RomanNumeralGUI(inputs, sort, unsorted); // creates a new RomanNumeralGui object called romanGui and it takes String inputs, SortedRomanNumeralList sort, and UnsortedRomanNumeralList unsorted

    }
}