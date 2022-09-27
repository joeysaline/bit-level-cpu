/*
 * This class implements all methods of the Bit class and ensures they all perform as intended.
 */
public class BitTest {

    public static void runTests() {

        System.out.println("\n\n\nBIT TEST\n");
        testSetWithParameter(false);
        testSetWithParameter(true);

        testSet(false);
        testSet(true);

        testClear(false);
        testClear(true);

        testToggle(false);
        testToggle(true);

        testAnd(false, false);
        testAnd(false, true);
        testAnd(true, false);
        testAnd(true, true);

        testOr(false, false);
        testOr(false, true);
        testOr(true, false);
        testOr(true, true);

        testXor(false, false);
        testXor(false, true);
        testXor(true, false);
        testXor(true, true);

        testNot(false);
        testNot(true);

        testToString(false);
        testToString(true);
    }

    // checking for cases where bit is not initilized, will setting a value work
    // if bit is already initialized, will setting a value change bit to match said
    // value
    public static void testSetWithParameter(boolean first) {

        Bit empty = new Bit();
        Bit full = new Bit(!first); // initializing with complement to test if passing value will change it

        System.out.println("testing set on empty bit with value " + first);
        empty.set(first);
        displayResults(first, empty.getValue());

        System.out.println("testing set on full bit with value " + first);
        full.set(first);
        displayResults(first, full.getValue());
    }

    // checking for cases where bit is not initlized, will set initialize it true
    // if bit is already false, will it change to true
    public static void testSet(boolean first) {

        Bit empty = new Bit();
        Bit full = new Bit(first);

        System.out.println("testing set on empty bit");
        empty.set();
        displayResults(true, empty.getValue()); // should always match true

        System.out.println("testing set on full bit initialized to " + first);
        full.set();
        displayResults(true, empty.getValue()); // should always match true
    }

    // checking for same cases as set but must match false
    public static void testClear(boolean first) {

        Bit empty = new Bit();
        Bit full = new Bit(first);

        System.out.println("testing clear on empty bit");
        empty.clear();
        displayResults(false, empty.getValue()); // should always match false

        System.out.println("testing clear on full bit initialized to " + first);
        full.clear();
        displayResults(false, full.getValue()); // should always match false
    }

    // check if bit is the complement of what is was initialzied to
    // default bit is false so should be true
    public static void testToggle(boolean first) {

        Bit empty = new Bit();
        Bit full = new Bit(first);

        System.out.println("testing toggle on empty bit");
        empty.toggle();
        displayResults(true, empty.getValue()); // should match true since it was defaulted to false

        System.out.println("testing toggle on full bit iniatlized to " + first);
        full.toggle();
        displayResults(!first, full.getValue()); // should match the complement
    }

    // checking to see if tests match up to the truth table
    public static void testAnd(boolean first, boolean second) {

        Bit one = new Bit(first);
        Bit two = new Bit(second);
        boolean expected, actual;

        System.out.println("testing AND with values " + first + " and " + second);
        expected = one.getValue() && two.getValue();
        actual = one.and(two).getValue();
        displayResults(expected, actual);
    }

    // check against or truth table
    public static void testOr(boolean first, boolean second) {

        Bit one = new Bit(first);
        Bit two = new Bit(second);
        boolean expected, actual;

        System.out.println("testing OR with values " + first + " and " + second);
        expected = one.getValue() || two.getValue();
        actual = one.or(two).getValue();
        displayResults(expected, actual);
    }

    // check against xor truth table
    public static void testXor(boolean first, boolean second) {

        Bit one = new Bit(first);
        Bit two = new Bit(second);
        boolean expected, actual;

        System.out.println("testing XOR with values " + first + " and " + second);
        expected = one.getValue() ^ two.getValue();
        actual = one.xor(two).getValue();
        displayResults(expected, actual);
    }

    // check against not truth table
    public static void testNot(boolean first) {

        Bit one = new Bit(first);
        boolean expected, actual;

        System.out.println("testing NOT with value " + first);
        expected = !one.getValue();
        actual = one.not().getValue();
        displayResults(expected, actual);
    }

    public static void testToString(boolean first) {

        Bit one = new Bit(first);

        System.out.println("testing toString, true is t false is f, value passed is " + first);
        System.out.println("result: " + one.toString());
    }

    // code reuse, to easily show if the methods function correctly
    public static void displayResults(boolean first, boolean second) {

        if (first == second)
            System.out.println("test passed: " + first + "=" + second + "\n");
        else
            System.out.println("test failed: " + first + "!=" + second + "\n");
    }

    public static void main(String args[]) {

        runTests();
    }
}