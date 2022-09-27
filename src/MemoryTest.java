public class MemoryTest {

    public static void runTests() {

        ALUTest.runTests();
        System.out.println("\n\n\nMEMORY TEST\n\n");
        Memory mem = new Memory();
        Longword a0 = new Longword();
        Longword a4 = new Longword(4);
        Longword a230 = new Longword(230);
        Longword a1020 = new Longword(1020);
        Longword a1023 = new Longword(1023);

        System.out.println("\nTest phase 1: Reading initial memory should be empty\n");
        System.out.println(mem.read(a0));
        System.out.println(mem.read(a4));
        System.out.println(mem.read(a230));
        System.out.println(mem.read(a1020));
        System.out.println(mem.read(a1023));

        System.out.println("\nTest phase 2: Writing to various addresses should populate them\n");
        mem.write(a0, new Longword(893));
        System.out.println(mem.read(a0));
        mem.write(a4, new Longword(849202));
        System.out.println(mem.read(a4));
        mem.write(a230, new Longword(8383751));
        System.out.println(mem.read(a230));
        mem.write(a1020, new Longword(39));
        System.out.println(mem.read(a1020));
        mem.write(a1023, new Longword(838375199));
        System.out.println(mem.read(a1020));
        /*
         * Special case: should be all false as 1024 is out of bounds bit, using max
         * number which would normally be all true bits
         */
        mem.write(new Longword(1024), new Longword(2147483647));
        System.out.println(mem.read(new Longword(1024)));

        System.out.println("\nTest phase 3: Ensuring read and write can properly store an integer\n");
        mem.write(a0, new Longword(0));
        displayResults(new Longword(0), mem.read(a0));
        mem.write(a0, new Longword(849302));
        displayResults(new Longword(849302), mem.read(a0));
        mem.write(a4, new Longword(-72));
        displayResults(new Longword(-72), mem.read(a4));
        mem.write(a230, new Longword(-100000));
        displayResults(new Longword(-100000), mem.read(a230));
        mem.write(a230, new Longword(41));
        displayResults(new Longword(41), mem.read(a230));
        mem.write(a230, new Longword(2140000231));
        displayResults(new Longword(2140000231), mem.read(a230));
        mem.write(a1020, new Longword(7473));
        displayResults(new Longword(7473), mem.read(a1020));
        /*
         * Special case: shifting right and then left 24 bits sets all bits to false
         * except
         * the first byte which should give the same result as reading the last address
         */
        mem.write(a1023, new Longword(2140000231));
        displayResults(new Longword(2140000231).rightShift(24).leftShift(24), mem.read(a1023));
    }

    public static void displayResults(Longword control, Longword actual) {

        if (control.getSigned() == actual.getSigned())
            System.out.println("Test passed: " + control.getSigned() + " == " + actual.getSigned());
        else
            System.out.println("Test failed: " + control.getSigned() + " != " + actual.getSigned());
    }

    public static void main(String[] args) {

        runTests();
    }
}
