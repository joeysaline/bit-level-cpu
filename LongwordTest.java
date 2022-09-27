public class LongwordTest {

    public static void runTests() {

        BitTest.runTests();
        System.out.println("\n\n\nLONGWORD TEST\n");
        testAnd();
        testOr();
        testXor();
        testNot();
        testLeftShift();
        testRightShift();
        testGetUnsigned();
        testGetSigned();
        testCopy();
        testSet();
        testToString();
    }

    public static void testAnd() {

        Longword firstWord = new Longword();
        firstWord.setBit(28, new Bit(true));
        firstWord.setBit(29, new Bit(true));

        Longword secondWord = new Longword();
        secondWord.setBit(29, new Bit(true));
        secondWord.setBit(30, new Bit(true));

        System.out.println("\ntesting AND");
        Longword result;
        result = firstWord.and(secondWord);
        displayResults(false, result.getBit(28).getValue());
        displayResults(true, result.getBit(29).getValue());
        displayResults(false, result.getBit(30).getValue());
        displayResults(false, result.getBit(31).getValue());
    }

    public static void testOr() {

        Longword firstWord = new Longword();
        firstWord.setBit(28, new Bit(true));
        firstWord.setBit(29, new Bit(true));

        Longword secondWord = new Longword();
        secondWord.setBit(29, new Bit(true));
        secondWord.setBit(30, new Bit(true));

        System.out.println("\ntesting OR");
        Longword result;
        result = firstWord.or(secondWord);
        displayResults(true, result.getBit(28).getValue());
        displayResults(true, result.getBit(29).getValue());
        displayResults(true, result.getBit(30).getValue());
        displayResults(false, result.getBit(31).getValue());
    }

    public static void testXor() {

        Longword firstWord = new Longword();
        firstWord.setBit(28, new Bit(true));
        firstWord.setBit(29, new Bit(true));

        Longword secondWord = new Longword();
        secondWord.setBit(29, new Bit(true));
        secondWord.setBit(30, new Bit(true));

        System.out.println("\ntesting XOR");

        Longword result;
        result = firstWord.xor(secondWord);
        displayResults(true, result.getBit(28).getValue());
        displayResults(false, result.getBit(29).getValue());
        displayResults(true, result.getBit(30).getValue());
        displayResults(false, result.getBit(31).getValue());
    }

    public static void testNot() {

        Longword word = new Longword();
        word.setBit(6, new Bit(true));

        System.out.println("testing NOT");
        Longword result = word.not();
        System.out.println(word.toString());
        System.out.println(result.toString());
        displayResults(true, result.getBit(5).getValue());
        displayResults(false, result.getBit(6).getValue());
    }

    public static void testLeftShift() {

        Longword word = new Longword();
        word.setBit(8, new Bit(true));
        word.setBit(0, new Bit(true));

        Longword result = word.leftShift(2);
        System.out.println("testing left shift");
        displayResults(false, result.getBit(8).getValue());
        displayResults(false, result.getBit(0).getValue());
        displayResults(true, result.getBit(6).getValue());
    }

    public static void testRightShift() {

        Longword word = new Longword();
        word.setBit(20, new Bit(true));
        word.setBit(0, new Bit(true));

        System.out.println("testing right shift");
        Longword result = word.rightShift(5);
        displayResults(false, result.getBit(20).getValue());
        displayResults(true, result.getBit(5).getValue());
    }

    public static void testGetUnsigned() {

        Longword word = new Longword();
        word.set(882993);
        System.out.println("testing get unsigned");
        System.out.println("should equal 882993, " + word.getUnsigned());
        word = new Longword();
        System.out.println("should equal 0, " + word.getUnsigned());
    }

    public static void testGetSigned() {

        Longword word = new Longword();
        word.set(10);
        System.out.println("testing get signed");
        System.out.println("should equal 10, " + word.getSigned());
        word = new Longword();
        word.set(-38477298);
        System.out.println("should equal -38477298, " + word.getSigned());
        word = new Longword();
        word.set(-8);
        System.out.println("should equal -8, " + word.getSigned());

        System.out.println(new Longword(4));
        System.out.println(new Longword(-4));
        System.out.println(new Longword(-4).getSigned());
    }

    public static void testCopy() {

        Longword word = new Longword();
        word.set(27);
        Longword copyWord = new Longword();
        word.copy(copyWord);
        System.out.println("testing copy");
        System.out.println(word.toString());
        System.out.println(copyWord.toString());
    }

    public static void testSet() {

        System.out.println("testing set");
        Longword word = new Longword();
        word.set(10);
        System.out.println("last 4 bits should be tftf");
        System.out.println(word.toString());
    }

    public static void testToString() {

        Longword word = new Longword();
        System.out.println("testing to string");
        System.out.println(word.toString());
        word.set(-784430);
        System.out.println(word.toString());
    }

    public static void displayResults(int control, int actual) {

        if (control == actual)
            System.out.println("test passed: " + control + "=" + actual + "\n");
        else
            System.out.println("test failed: " + control + "=" + actual + "\n");
    }

    public static void displayResults(Bit control, Bit actual) {

        BitTest.displayResults(control.getValue(), actual.getValue());
    }

    public static void displayResults(boolean control, boolean actual) {

        if (control == actual)
            System.out.println("test passed: " + control + "=" + actual + "\n");
        else
            System.out.println("test failed: " + control + "!=" + actual + "\n");
    }

    public static void main(String[] args) {
        runTests();
    }
}