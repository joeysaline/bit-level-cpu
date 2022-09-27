public class RippleAdderTest {

    public static void runTests() {

        LongwordTest.runTests();
        System.out.println("\n\n\nRIPPLEADDER TEST\n");
        testAdd();
        testSubtract();
    }

    public static void testAdd() {

        System.out.println("\nTESTING ADD");
        displayResults(new Longword(0), RippleAdder.add(new Longword(10), new Longword(-10)));
        displayResults(new Longword(20), RippleAdder.add(new Longword(10), new Longword(10)));
        displayResults(new Longword(10), RippleAdder.add(new Longword(-10), new Longword(20)));
        displayResults(new Longword(-10), RippleAdder.add(new Longword(10), new Longword(-20)));
        displayResults(new Longword(-20), RippleAdder.add(new Longword(-10), new Longword(-10)));
        displayResults(new Longword(-25), RippleAdder.add(new Longword(-50), new Longword(25)));
        displayResults(new Longword(25), RippleAdder.add(new Longword(50), new Longword(-25)));
        displayResults(new Longword(393554432), RippleAdder.add(new Longword(348958574), new Longword(44595858)));
        displayResults(new Longword(-479263857), RippleAdder.add(new Longword(-478475857), new Longword(-788000)));
        displayResults(new Longword(-1), RippleAdder.add(new Longword(3), new Longword(-4)));
        displayResults(new Longword(487094), RippleAdder.add(new Longword(487294), new Longword(-200)));
        displayResults(new Longword(-60), RippleAdder.add(new Longword(-70), new Longword(10)));
    }

    public static void testSubtract() {

        System.out.println("\nTESTING SUBTRACT");
        displayResults(new Longword(0), RippleAdder.subtract(new Longword(10), new Longword(10)));
        displayResults(new Longword(-20), RippleAdder.subtract(new Longword(-10), new Longword(10)));
        displayResults(new Longword(20), RippleAdder.subtract(new Longword(10), new Longword(-10)));
        displayResults(new Longword(10), RippleAdder.subtract(new Longword(-10), new Longword(-20)));
        displayResults(new Longword(-60), RippleAdder.subtract(new Longword(-50), new Longword(10)));
        displayResults(new Longword(60), RippleAdder.subtract(new Longword(50), new Longword(-10)));
        displayResults(new Longword(-40), RippleAdder.subtract(new Longword(-50), new Longword(-10)));
        displayResults(new Longword(477687857), RippleAdder.subtract(new Longword(478475857), new Longword(788000)));
        displayResults(new Longword(-10885788), RippleAdder.subtract(new Longword(-893399), new Longword(9992389)));

    }

    public static void displayResults(Longword control, Longword actual) {

        if (control.getSigned() == actual.getSigned())
            System.out.println("test passed: " + control.getSigned() + " = " + actual.getSigned());
        else
            System.out.println("test failed: " + control.getSigned() + " != " + actual.getSigned());
    }

    public static void displayResults(Bit control, Bit actual) {

        LongwordTest.displayResults(control, actual);
    }

    public static void main(String[] args) {
        runTests();
    }
}
