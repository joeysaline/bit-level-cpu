/*
 * Joey Saline
 * ICSI 404
 * Assignment 5 - Computer
 */
public class Computer {

    /* Fields */

    // computers memory storage
    private Memory computerMemory;
    private Bit halt; // when true the computer should be halted, when false the computer is allowed
                      // to run

    /* Methods */

    public Computer() {

        computerMemory = new Memory();
        halt = new Bit(true);
    }

    public void run() {

        // will loop while halt is set to false
        while (!halt.getValue()) {

            fetch();
            decode();
            execute();
            store();
        }
    }

    public void fetch() {

    }

    public void decode() {

    }

    public void execute() {

    }

    public void store() {

    }
}
