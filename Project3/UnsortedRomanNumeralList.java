/**
 * The class extends RomanNumeralList class and appends a new Roman numeral to the end of the unsorted list
 *
 * @author N. Karim
 */
public class UnsortedRomanNumeralList extends RomanNumeralList {
    /**
     * Appends a new Roman numeral to the unsorted list
     * @param roman the Roman Numeral to be added to the list
     */
    public void append(RomanNumeral roman) { // method to add a new roman numeral to the end of the unsorted list
        RomanNumeralListNode newNode = new RomanNumeralListNode(roman.getRoman()); // creates new RomanNumeralListNode object with roman passed
        RomanNumeralListNode current = head; // sets current to head of the linked list
        while (current.next != null) { // iterate through the linked list until the end is reached
            current = current.next; // moves current to next node
        }
        current.next = newNode; // sets next reference of current node to new node, which adds to end of linked list
    }
}
