public class RomanNumeralList {
    protected RomanNumeralListNode head; // declares the head of RomanNumeralListNode as protected
    protected RomanNumeralListNode tail; // declares the tail of RomanNumeralListNode as protected

    public RomanNumeralList() {
        head = new RomanNumeralListNode(null); // first node is dummy node
        tail = head; // set tail to be same as head
    }

    public String toString() { // toString method to return String
        RomanNumeralListNode p = head.next; // start at the node after the head
        String returnString = ""; // empty string is declared to be appended by the converted roman numerals
        while (p != null) { // loops through RomanNumeralList until it p equals null
            RomanNumeral convert = new RomanNumeral(p.data); // converts the roman numeral to arabic numeral using RomanNumeral class
            returnString += (convert.toString()) + "\n"; // appends converted arabic values to returnString
            p = p.next; // move to next node
        }
        return returnString; // returns string representation of RomanNumeralList
    }

}

