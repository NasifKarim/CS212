import java.util.HashMap;

/**
 * This class represents a Roman Numeral and its equivalent arabic numeral value
 * It provides methods for converting from Roman numerals to arabic numerals
 *
 * @author N. Karim
 */
public class RomanNumeral {
    private String roman;
    private int arabic;

    /**
     * Constructor for the RomanNumeral class which takes String argument representing a Roman numeral
     * it converts it to an Arabic numeral
     * if roman numeral is not valid then an exception is thrown
     *
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
     *
     * @param roman the Roman numeral string to convert
     * @return the equivalent Arabic numeral value
     */
    private int convertToArabic(String roman) {
        roman = roman.toUpperCase();
        int arabicNumeral = 0; // initializes the variable to hold the Arabic numeral value
        for (int i = 0; i < roman.length(); i++) { // for loop that iterates through each character in the Roman numeral
            char current = roman.charAt(i); // char current gets the current character in the Roman numeral
            int currentValue = getArabic(current);  // integer current value gets the value of the current character

            if (i + 1 < roman.length()) { // checks if there is a next character in the Roman numeral
                char next = roman.charAt(i + 1); // if the conditions meet,then gets the next character in the Roman numeral
                int nextValue = getArabic(next); // integer nextValue get the value of the next character and stores it

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
     * Uses HashMaps
     * Roman numeral characters mapped to their corresponding Arabic numeral values
     */
    private static HashMap<Character, Integer> getValue = new HashMap<>();

    static {

        getValue.put('I', 1); // maps I to 1
        getValue.put('V', 5); // maps V to 5
        getValue.put('X', 10); // maps X to 10
        getValue.put('L', 50); // maps L to 50
        getValue.put('C', 100); // maps C to 100
        getValue.put('D', 500); // maps D to 500
        getValue.put('M', 1000); // maps M to 1000
    }

    /**
     * converts a Roman numeral chracter to its arabic numeral value
     *
     * @param romanNumeral The Roman numeral character to be converted
     * @return The corresponding arabic value
     * @throws IllegalRomanNumeralException if the roman numeral character is invalid
     */
    public static int getArabic(char romanNumeral) {
        Integer value = getValue.get(romanNumeral); // retrieve the arabic numeral value from the mapping
        if (value == null) {
            throw new IllegalRomanNumeralException("The following Roman Numeral is not valid" + romanNumeral); // if value is null then threw IllegalRomanNumeralException
        }
        return value; // returns arabic numeral value
    }


    /**
     * Getter method for the Roman numeral value
     *
     * @return the roman numeral string
     */
    public String getRoman() { // get method for Roman numerals
        return roman;
    }

    /**
     * Getter method for the Arabic numeral value
     *
     * @return the Arabic numeral value
     */
    public int getArabic() { // get method for Arabic values
        return arabic;
    }

    /**
     * Setter method for Roman numeral value
     * updates its arabic value based on the new roman numeral
     *
     * @param r the new Roman numeral to set
     */
    public void setRoman(String r) { // set method for Roman numerals
        roman = r;
        arabic = convertToArabic(roman);
    }

    /**
     * returns Arabic value of roman numeral as a string
     *
     * @return the arabic value as a string
     */
    public String toString() {
        return String.valueOf(arabic); // returns the arabic numeral as a string
    }

    /**
     * Compares this roman numeral to another based on their arabic values
     *
     * @param other the other roman numeral value to compare to
     * @return the result of the comparison as an integer
     */
    public int compareTo(RomanNumeral other) {
        return Integer.compare(this.arabic, other.getArabic()); // compares the arabic values of current object and other object
    }

}



