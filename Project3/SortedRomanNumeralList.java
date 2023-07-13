/**
 * The class extends RomanNumeralList and adds a method to insert a new Roman numeral into the sorted list
 *
 * @author N. Karim
 */
public class SortedRomanNumeralList extends RomanNumeralList {
    /**
     * Adds a new Roman numeral to the sorted list
     *
     * @param roman The roman numeral to be added to the list
     */
    public void add(RomanNumeral roman) { // add method to add a new Roman numeral to the sorted list

        RomanNumeralListNode previous = head; // previous node is initialized to head of the linked list
        RomanNumeralListNode current = head.next; // current node is initialized to the second node in the linked list
        RomanNumeralListNode newNode = new RomanNumeralListNode(roman.getRoman()); // creates a new node with the new Roman numeral data

        if (current != null) { // if the linked list is empty
            RomanNumeral l = new RomanNumeral(current.data); // create new RomanNumeral object with current data passed
            while (current != null && l.compareTo(roman) < 0) { // iterate through linked as long conditions are true
                previous = previous.next; // move previous to next node
                current = current.next; // move current to next node
                if (current != null) {
                    l.setRoman(current.data); // if linked list is empty then set roman to current data
                }

            }
        }
        newNode.next = current; // sets next reference of new node to current node
        previous.next = newNode; // sets next reference of previous node to new node
    }
}
