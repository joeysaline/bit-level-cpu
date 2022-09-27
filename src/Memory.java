/*
 * Joey Saline
 * ICSI 404
 * Assignment 5 - Memory
 */
public class Memory {

    /* Fields */

    // 1024 bytes of memory for the computer
    private Bit[] memory;

    /* Methods */

    public Memory() {

        memory = new Bit[8192]; // 1024 bytes times 8 for bit conversion
        for (int i = 0; i < 8192; i++)
            this.memory[i] = new Bit();
    }

    // read a designated address from memory
    public Longword read(Longword address) {

        Longword result = new Longword();
        int j = 0;
        // catch out of bounds exception
        try {
            // iterate through the address by turning into the corresponding bits
            for (int i = address.getSigned() * 8; i < (address.getSigned() * 8 + 32); i++) {

                result.setBit(j, memory[i]);
                j++;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(
                    "Caught Exception: IndexOutOfBoundsException\n\tMemory tried to be read passed address 1023. Remaining bits read will be false.");
            j = 0;
            // since exception was thrown, we can assume the address is one of the last
            // three and use this algorithm for all cases
            for (int i = address.getSigned() * 8; i < 8192; i++) {

                result.setBit(j, memory[i]);
                j++;
            }
            // read out of bounds bits as false
            while (j < 32) {

                result.setBit(j, new Bit());
                j++;
            }
        }
        return result;
    }

    // write a value to specified address in memory
    public void write(Longword address, Longword value) {

        int j = 0;
        // catch out of bounds exception
        try {
            // iterate through the address by turning into corresponding bits
            for (int i = address.getSigned() * 8; i < (address.getSigned() * 8 + 32); i++) {

                memory[i] = value.getBit(j);
                j++;
            }
        } catch (IndexOutOfBoundsException e) {

            // ignore remaining bits
            System.out.println(
                    "Caught Exception: IndexOutOfBoundsException\n\tMemory tried to be written passed address 1023. Remaining bits to be written will be ignored.");
        }
    }
}
