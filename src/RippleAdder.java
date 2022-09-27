/*
 * Joey Saline
 * ICSI 404
 * Assignment 3 - The Ripple Adder
 */
public class RippleAdder {

    public static Longword add(Longword a, Longword b) {

        Longword result = new Longword();
        Bit carry = new Bit(false);
        for (int i = 31; i >= 0; i--) {

            result.setBit(i, a.getBit(i).xor(b.getBit(i)).xor(carry));
            carry = a.getBit(i).and(b.getBit(i)).or((a.getBit(i).xor(b.getBit(i))).and(carry));
        }
        return result;
    }

    public static Longword subtract(Longword a, Longword b) {
        
        // adds a to the twos complement of b acting as subtraction
        return add(a, add(b.not(), new Longword(1)));
    }
}