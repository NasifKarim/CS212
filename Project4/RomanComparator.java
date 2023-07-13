import java.util.Comparator;

/**
 * Comparator implementation for comparing RomanNumeral objects
 *
 * @author N. Karim
 */
public class RomanComparator implements Comparator<RomanNumeral> {
    /**
     * Compares two RomanNumerals
     *
     * @param num1 the first RomanNumeral object to be compared.
     * @param num2 the second RomanNumeral object to be compared.
     * @return the result of the comparison as an integer
     */
    public int compare(RomanNumeral num1, RomanNumeral num2) {
        return num1.compareTo(num2);
    }
}
