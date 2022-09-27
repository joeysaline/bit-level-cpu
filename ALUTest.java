public class ALUTest {

    public static void runTests() {

        
        RippleAdderTest.runTests();
        System.out.println("\n\n\nALU TEST\n\n");
        Bit[] an = { new Bit(true), new Bit(false), new Bit(false), new Bit(false) };
        Bit[] oR = { new Bit(true), new Bit(false), new Bit(false), new Bit(true) };
        Bit[] xoR = { new Bit(true), new Bit(false), new Bit(true), new Bit(false) };
        Bit[] n = { new Bit(true), new Bit(false), new Bit(true), new Bit(true) };
        Bit[] ls = { new Bit(true), new Bit(true), new Bit(false), new Bit(false) };
        Bit[] rs = { new Bit(true), new Bit(true), new Bit(false), new Bit(true) };
        Bit[] ad = { new Bit(true), new Bit(true), new Bit(true), new Bit(false) };
        Bit[] sub = { new Bit(true), new Bit(true), new Bit(true), new Bit(true) };
        Bit[] m = { new Bit(false), new Bit(true), new Bit(true), new Bit(true) };

        Longword three = new Longword(3);
        Longword negThree = new Longword(-3);
        Longword seven = new Longword(7);
        Longword negSeven = new Longword(-7);
        Longword zero = new Longword(0);
        Longword largeNum = new Longword(8472022);
        Longword medNum = new Longword(4932);
        Longword negLargeNum = new Longword(-932003);
        Longword negMedNum = new Longword(-582);

        System.out.println("\nTESTING AND");
        System.out.println("7 && 3\n" + ALU.doOp(an, seven, three).getSigned());
        System.out.println("-7 && 3\n" + ALU.doOp(an, negSeven, three).getSigned());
        System.out.println("7 && -3\n" + ALU.doOp(an, seven, negThree).getSigned());
        System.out.println("0 && -582\n" + ALU.doOp(an, zero, negMedNum).getSigned());
        System.out.println("4932 && 8472022\n" + ALU.doOp(an, medNum, largeNum).getSigned());
        System.out.println("8472022 && -582\n" + ALU.doOp(an, largeNum, negMedNum).getSigned());
        System.out.println("-932003 && -582\n" + ALU.doOp(an, negLargeNum, negMedNum).getSigned());

        System.out.println("\nTESTING OR");
        System.out.println("7 || 3\n" + ALU.doOp(oR, seven, three).getSigned());
        System.out.println("-7 || 3\n" + ALU.doOp(oR, negSeven, three).getSigned());
        System.out.println("7 || -3\n" + ALU.doOp(oR, seven, negThree).getSigned());
        System.out.println("0 || -582\n" + ALU.doOp(oR, zero, negMedNum).getSigned());
        System.out.println("4932 || 8472022\n" + ALU.doOp(oR, medNum, largeNum).getSigned());
        System.out.println("8472022 || -582\n" + ALU.doOp(oR, largeNum, negMedNum).getSigned());
        System.out.println("-932003 || -582\n" + ALU.doOp(oR, negLargeNum, negMedNum).getSigned());

        System.out.println("\nTESTING XOR");
        System.out.println("7 ^ 3\n" + ALU.doOp(xoR, seven, three).getSigned());
        System.out.println("-7 ^ 3\n" + ALU.doOp(xoR, negSeven, three).getSigned());
        System.out.println("7 ^ -3\n" + ALU.doOp(xoR, seven, negThree).getSigned());
        System.out.println("0 ^ -582\n" + ALU.doOp(xoR, zero, negMedNum).getSigned());
        System.out.println("4932 ^ 8472022\n" + ALU.doOp(xoR, medNum, largeNum).getSigned());
        System.out.println("8472022 ^ -582\n" + ALU.doOp(xoR, largeNum, negMedNum).getSigned());
        System.out.println("-932003 ^ -582\n" + ALU.doOp(xoR, negLargeNum, negMedNum).getSigned());

        System.out.println("\nTESTING NOT");
        System.out.println("~ 7\n" + ALU.doOp(n, seven, three).getSigned());
        System.out.println("~ 3\n" + ALU.doOp(n, three, three).getSigned());
        System.out.println("~ -7\n" + ALU.doOp(n, negSeven, negThree).getSigned());
        System.out.println("~ 0\n" + ALU.doOp(n, zero, negMedNum).getSigned());
        System.out.println("~ 8472022\n" + ALU.doOp(n, largeNum, largeNum).getSigned());
        System.out.println("~ -582\n" + ALU.doOp(n, negMedNum, negMedNum).getSigned());
        System.out.println("~ -932003\n" + ALU.doOp(n, negLargeNum, negMedNum).getSigned());

        System.out.println("\nTESTING LEFTSHIFT");
        System.out.println("7 << 3\n" + ALU.doOp(ls, seven, three).getSigned());
        System.out.println("-7 << 3\n" + ALU.doOp(ls, negSeven, three).getSigned());
        System.out.println("-582 << 7\n" + ALU.doOp(ls, negMedNum, seven).getSigned());
        System.out.println("0 << 3\n" + ALU.doOp(ls, zero, three).getSigned());
        System.out.println("4932 << 3\n" + ALU.doOp(ls, medNum, three).getSigned());
        System.out.println("8472022 << 7\n" + ALU.doOp(ls, largeNum, seven).getSigned());
        System.out.println("-932003 << -7\n" + ALU.doOp(ls, negLargeNum, negSeven).getSigned());

        System.out.println("\nTESTING RIGHTSHIFT");
        System.out.println("7 >> 3\n" + ALU.doOp(rs, seven, three).getSigned());
        System.out.println("-7 >> 3\n" + ALU.doOp(rs, negSeven, three).getSigned());
        System.out.println("-582 >> 7\n" + ALU.doOp(rs, negMedNum, seven).getSigned());
        System.out.println("0 >> 3\n" + ALU.doOp(rs, zero, three).getSigned());
        System.out.println("4932 >> 3\n" + ALU.doOp(rs, medNum, three).getSigned());
        System.out.println("8472022 >> 7\n" + ALU.doOp(rs, largeNum, seven).getSigned());
        System.out.println("-932003 >> -7\n" + ALU.doOp(rs, negLargeNum, negSeven).getSigned());

        System.out.println("\nTESTING ADD");
        System.out.println("7 + 3\n" + ALU.doOp(ad, seven, three).getSigned());
        System.out.println("-7 + 3\n" + ALU.doOp(ad, negSeven, three).getSigned());
        System.out.println("7 + -3\n" + ALU.doOp(ad, seven, negThree).getSigned());
        System.out.println("0 + -582\n" + ALU.doOp(ad, zero, negMedNum).getSigned());
        System.out.println("4932 + 8472022\n" + ALU.doOp(ad, medNum, largeNum).getSigned());
        System.out.println("8472022 + -582\n" + ALU.doOp(ad, largeNum, negMedNum).getSigned());
        System.out.println("-932003 + -582\n" + ALU.doOp(ad, negLargeNum, negMedNum).getSigned());

        System.out.println("\nTESTING SUBTRACT");
        System.out.println("7 - 3\n" + ALU.doOp(sub, seven, three).getSigned());
        System.out.println("-7 - 3\n" + ALU.doOp(sub, negSeven, three).getSigned());
        System.out.println("7 - -3\n" + ALU.doOp(sub, seven, negThree).getSigned());
        System.out.println("0 - -582\n" + ALU.doOp(sub, zero, negMedNum).getSigned());
        System.out.println("4932 - 8472022\n" + ALU.doOp(sub, medNum, largeNum).getSigned());
        System.out.println("8472022 - -582\n" + ALU.doOp(sub, largeNum, negMedNum).getSigned());
        System.out.println("-932003 - -582\n" + ALU.doOp(sub, negLargeNum, negMedNum).getSigned());

        System.out.println("\nTESTING MULTIPLY");
        System.out.println("7 * 3\n" + ALU.doOp(m, seven, three).getSigned());
        System.out.println("-7 * 3\n" + ALU.doOp(m, negSeven, three).getSigned());
        System.out.println("7 * -3\n" + ALU.doOp(m, seven, negThree).getSigned());
        System.out.println("0 * -582\n" + ALU.doOp(m, zero, negMedNum).getSigned());
        System.out.println("4932 * 8472022\n" + ALU.doOp(m, medNum, largeNum).getSigned());
        System.out.println("8472022 * -582\n" + ALU.doOp(m, largeNum, negMedNum).getSigned());
        System.out.println("-932003 * -582\n" + ALU.doOp(m, negLargeNum, negMedNum).getSigned());
    }

    public static void main(String[] args) {

        runTests();
    }
}
