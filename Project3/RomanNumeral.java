/**
 * This class represents a Roman Numeral and its equivalent arabic numeral value
 * It provides methods for converting from Roman numerals to arabic numerals
 * @author N. Karim
 */
public class RomanNumeral {
    private String roman;
    private int arabic;

    /**
     * Constructor for the RomanNumeral class which takes String argument representing a Roman numeral
     * it converts it to an Arabic numeral
     * if roman numeral is not valid then an exception is thrown
     * @param r the Roman numeral string
     * @throws IllegalArgumentException if invalid input
     */
    public RomanNumeral(String r) {
        roman = r;
        r = r.toUpperCase(); // changes any roman numerals to uppercase
        if (!r.matches("[MDCLXVI]+")) { // if the roman numeral entered does not match those letters, throw exception
            throw new IllegalRomanNumeralException("The following Roman Numeral is not valid : " + r);
        }
        arabic = convertToArabic(roman); // calls the convertToArabic method to convert from Roman Numerals to Arabic
    }

    /**
     * private helper method that converts a Roman numeral string to arabic value
     * @param roman the Roman numeral string to convert
     * @return the equivalent Arabic numeral value
     */
    private int convertToArabic(String roman) {
        roman = roman.toUpperCase();
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

    /**
     * Private helper method that gets the value of a Roman numeral
     * @param romanNumeral the Roman numeral character
     * @return the Arabic numeral value of the Roman numeral character
     */
    private static int getValue(char romanNumeral) { // this method takes character romanNumeral as an argument and pairs each Roman Numeral with its Arabic Numeral
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

    /**
     * Getter method for the Roman numeral value
     * @return the roman numeral string
     */
    public String getRoman() { // get method for Roman numerals
        return roman;
    }

    /**
     * Getter method for the Arabic numeral value
     * @return the Arabic numeral value
     */
    public int getArabic() { // get method for Arabic values
        return arabic;
    }

    /**
     * Setter method for Roman numeral value
     * updates its arabic value based on the new roman numeral
     * @param r the new Roman numeral to set
     */
    public void setRoman(String r) { // set method for Roman numerals
        roman = r;
        arabic = convertToArabic(roman);
    }

    /**
     * returns Arabic value of roman numeral as a string
     * @return the arabic value as a string
     */
    public String toString() {
        return String.valueOf(arabic); // returns the arabic numeral as a string
    }

    /**
     * Compares this roman numeral to another based on their arabic values
     * @param other the other roman numeral value to compare to
     * @return the result of the comparison as an integer
     */
    public int compareTo(RomanNumeral other) {
        return Integer.compare(this.arabic, other.getArabic()); // compares the arabic values of current object and other object
    }

    }



