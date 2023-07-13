/**
 * This class represents a node in a linked list of Roman numerals
 * @author N. Karim
 */
public class RomanNumeralListNode {
    /**
     * The data stored in this node
     */
    public String data; // declares public string called data
    /**
     * A reference to the next node
     */
    public RomanNumeralListNode next; // declares public reference to the next node

    /**
     * Constructs a new node with specific data
     * @param d the data to be stored in the new node
     */
    public RomanNumeralListNode(String d) {
        data = d; // sets data to parameter passed which is String d
        next = null; // sets next reference to null
    }
}

