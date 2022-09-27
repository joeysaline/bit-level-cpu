/*
 * Joey Saline
 * ICSI 404
 * Assignment 4 - The Multiplier
 */
public class Multiplier {

    public static Longword multiply(Longword a, Longword b) {

        Longword result = new Longword();
        for (int i = 31; i >= 0; i--) {

            if (b.getBit(i).getValue() == true)
                result = RippleAdder.add(result, a);
            a = a.leftShift(1);
        }
        return result;
    }
}
