/**
 * Joey Saline
 * ICSI 404
 * Assignment 1 - The Simple Bit
 */
public class Bit {

    private boolean value;

    public Bit() {

        this.value = false;
    }

    public Bit(boolean value) {

        this.value = value;
    }

    public void set(boolean value) {

        this.value = value;
    }

    public void toggle() {

        if (this.value == false)
            this.value = true;
        else
            this.value = false;
    }

    public void set() {

        this.value = true;
    }

    public void clear() {

        this.value = false;
    }

    public boolean getValue() {

        return this.value;
    }

    // logical AND to manipulate bits
    public Bit and(Bit other) {

        Bit result = new Bit();
        if (this.value == true) {
            if (other.getValue() == true)
                result.set();
        }
        return result;
    }

    // logical OR to manipulate bits
    public Bit or(Bit other) {

        Bit result = new Bit();
        if (this.value == true)
            result.set();
        else if (other.getValue() == true)
            result.set();
        return result;
    }

    // logical XOR to manipulate bits
    public Bit xor(Bit other) {

        Bit result = new Bit();
        if (this.value == true) {
            if (other.getValue() == false)
                result.set();
        } else {
            if (other.getValue() == true)
                result.set();
        }
        return result;
    }

    // logical NOT to manipulate bits
    public Bit not() {

        Bit result = new Bit(this.value);
        result.toggle();
        return result;
    }

    public String toString() {

        if (this.value == true)
            return "t";
        return "f";
    }
}