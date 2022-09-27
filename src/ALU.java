/*
 * Joey Saline
 * ICSI 404
 * Assignment 4 - The ALU
 */
public class ALU {

    public static Longword doOp(Bit[] operation, Longword a, Longword b) {

        Longword result = new Longword();
        String operationCode = "";

        for (Bit i : operation)
            operationCode += i.toString();
        // System.out.println(operationCode);
        switch (operationCode) {

            case "tfff":
                return a.and(b);
            case "tfft":
                return a.or(b);
            case "tftf":
                return a.xor(b);
            case "tftt":
                return a.not();
            case "ttff":
                return a.leftShift((int) a.and(new Longword(31)).getUnsigned());
            case "ttft":
                return a.rightShift((int) a.and(new Longword(31)).getUnsigned());
            case "tttf":
                return RippleAdder.add(a, b);
            case "tttt":
                return RippleAdder.subtract(a, b);
            case "fttt":
                return Multiplier.multiply(a, b);
            default:
                return result;
        }
    }
}
