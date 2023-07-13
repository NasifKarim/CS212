public class RomanNumeral {
    private String roman;
    private int arabic;

    public RomanNumeral(String r) {
        roman = r;
        arabic = convertToArabic(roman); // calls the convertToArabic method to convert from Roman Numerals to Arabic
    }

    private int convertToArabic(String roman) {
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

    public String getRoman() { // get method for Roman numerals
        return roman;
    }

    public int getArabic() { // get method for Arabic values
        return arabic;
    }

    public void setRoman(String r) { // set method for Roman numerals
        roman = r;
        arabic = convertToArabic(roman);
    }

    public String toString() {
        return String.valueOf(arabic); // returns the arabic numeral as a string
    }

    public int compareTo(RomanNumeral other) {
        return Integer.compare(this.arabic, other.getArabic()); // compares the arabic values of current object and other object
    }

    public boolean equals(RomanNumeral other) {
        return roman.equals(other.getRoman()) && // checks if roman value of current object is equal to other object
                arabic == other.getArabic(); // checks if arabic value is equal to other object
    }
}


