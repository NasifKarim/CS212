public class IllegalRomanNumeralException extends IllegalArgumentException {
    public IllegalRomanNumeralException (RomanNumeral message) {
        super (String.valueOf(message));
    }
}
