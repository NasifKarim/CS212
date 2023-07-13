/**
 * This class extends IllegalArgumentException class
 * Exception is thrown when illegal Roman Numeral is inputted
 * @author N. Karim
 */
public class IllegalRomanNumeralException extends IllegalArgumentException {
    /**
     * Constructs new IllegalRomanNumeralException with message
     * @param message the message shown to user
     */
    public IllegalRomanNumeralException(String message) {
        super(message); // the error message
    }
}
