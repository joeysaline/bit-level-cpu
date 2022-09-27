/*
 * Joey Saline
 * ICSI 404
 * Assignment 2 - The Ubiquitous Longword
 */
public class Longword {

    private Bit[] bits = new Bit[32];

    public Longword() {

        for (int i = 0; i < 32; i++) {

            this.bits[i] = new Bit(false);
        }
    }

    public Longword(int number) {

        for (int i = 0; i < 32; i++) {

            this.bits[i] = new Bit(false);
        }
        this.set(number);
    }

    public Bit getBit(int i) {

        return this.bits[i];
    }

    public void setBit(int i, Bit value) {

        this.bits[i].set(value.getValue());
    }

    public Longword and(Longword other) {

        Longword result = new Longword();
        for (int i = 0; i < 32; i++) {

            result.bits[i] = this.bits[i].and(other.bits[i]);
        }
        return result;
    }

    public Longword or(Longword other) {

        Longword result = new Longword();
        for (int i = 0; i < 32; i++) {

            result.bits[i] = this.bits[i].or(other.bits[i]);
        }
        return result;
    }

    public Longword xor(Longword other) {

        Longword result = new Longword();
        for (int i = 0; i < 32; i++) {

            result.bits[i] = this.bits[i].xor(other.bits[i]);
        }
        return result;
    }

    public Longword not() {

        Longword result = new Longword();
        for (int i = 0; i < 32; i++) {

            result.bits[i] = this.bits[i].not();
        }
        return result;
    }

    public Longword leftShift(int amount) {

        Longword result = new Longword();
        Longword temp = new Longword();
        copy(temp);
        for (int j = 0; j < amount; j++) {
            for (int i = 0; i < 31; i++) {

                // replaces a bit with the one to its right, shifting left
                result.bits[i] = temp.bits[i + 1];
            }
            // the last bit cannot be shifted but should be false
            result.bits[31].clear();
            temp = result;
        }
        return result;
    }

    public Longword rightShift(int amount) {

        Longword result = new Longword();
        Longword temp = new Longword();
        copy(temp);
        for (int j = 0; j < amount; j++) {
            for (int i = 31; i > 0; i--) {

                // replaces a bit with the one to its left, shifting right
                result.bits[i] = temp.bits[i - 1];
            }
            // the first bit cannot be shifted but should be false
            result.bits[0].clear();
            temp = result;
        }
        return result;
    }

    public long getUnsigned() {

        long number = 0, factor = 1;
        for (int i = 31; i >= 0; i--) {

            // algorithm to convert binary into decimal with the first bit utilized as power
            // of 2
            if (this.bits[i].getValue() == true)
                number += factor;
            factor *= 2;
        }
        return number;
    }

    public int getSigned() {

        int number = 0;
        long factor = 1;
        // check for negative number
        if (this.bits[0].getValue() == true) {

            // take twos complement to bring bits back to readable state
            Longword temp = new Longword();
            Longword result = new Longword();
            temp = not();
            result = not();
            Longword one = new Longword(1);
            Bit carry = new Bit(false);
            for (int i = 31; i >= 0; i--) {

                result.setBit(i, temp.getBit(i).xor(one.getBit(i)).xor(carry));
                carry = temp.getBit(i).and(one.getBit(i)).or((temp.getBit(i).xor(one.getBit(i))).and(carry));
            }
            // convert binary into decimal
            for (int i = 31; i > 0; i--) {

                if (result.getBit(i).getValue() == true)
                    number += factor;
                factor *= 2;
            }
            number *= -1;
        } else {
            // convert binary into decimal
            for (int i = 31; i > 0; i--) {

                if (this.bits[i].getValue() == true)
                    number += factor;
                factor *= 2;
            }
        }
        return number;
    }

    public void copy(Longword other) {

        int i = 0;
        for (Bit b : this.bits) {

            other.bits[i] = b;
            i++;
        }
    }

    public void set(int number) {

        int factor = 1073741824;
        if (number < 0) {

            number *= -1;
            for (int i = 1; i < 32; i++) {

                // algorithm to convert decimal into binary
                if (number >= factor)
                    this.bits[i].set();
                else
                    this.bits[i].clear();
                number = number % factor;
                factor /= 2;
            }
            Longword temp = new Longword();
            temp = not();
            // System.out.println(this);
            // System.out.println(temp);
            Longword one = new Longword(1);
            Bit carry = new Bit(false);
            for (int i = 31; i >= 0; i--) {

                setBit(i, temp.getBit(i).xor(one.getBit(i)).xor(carry));
                carry = temp.getBit(i).and(one.getBit(i)).or((temp.getBit(i).xor(one.getBit(i))).and(carry));
            }
        } else {

            for (int i = 1; i < 32; i++) {

                // algorithm to convert decimal into binary
                if (number >= factor)
                    this.bits[i].set();
                else
                    this.bits[i].clear();
                number = number % factor;
                factor /= 2;
            }
        }
    }

    public String toString() {

        String longwordString = "";
        for (Bit b : bits) {
            longwordString += b.toString();
        }
        return longwordString;
    }
    // public void set(int number) {

    // int factor = 1073741824; // largest factor for a signed 32 bit longword
    // if (number < 0) {

    // // sign of number must be accounted for with first bit
    // this.bits[0].set();
    // // put number to positive so alogrithm can function properly
    // number *= -1;
    // } else
    // this.bits[0].clear();
    // for (int i = 1; i < 32; i++) {

    // // algorithm to convert decimal into binary
    // if (number >= factor)
    // this.bits[i].set();
    // else
    // this.bits[i].clear();
    // number = number % factor;
    // factor /= 2;
    // }
    // }
}
