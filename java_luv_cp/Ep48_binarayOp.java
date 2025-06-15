import java.util.Scanner;

public class Ep48_binarayOp {

    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num >> i) & 1);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a = 5;
        printBinary(a);

        int set_count = 0, unset_count = 0;
        for (int i = 31; i >= 0; --i) {
            if ((a & ((1 << i))) != 0) {
                set_count++;
            } else {
                unset_count++;
            }
        }

        System.out.println(set_count + " " + unset_count);
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            if ((n & 1) != 0) {
                System.out.println("odd");
            } else {
                System.out.println("even");
            }
        }

        /* multiply and division by 2 using shift */

        // multiply
        int x = 4;
        System.out.println(x << 1); // 8 multiplication by 2.

        // division
        System.out.println(x >> 1); // 2 divided by 2

        /*
         * 
         * capital small
         * A = 00001000001 a= 00001100001
         * B=00001000010 b=00001100010
         * C=00001000011 c=00001100011
         * D=00001000100 d=00001100100
         * E=00001000101 e=00001100101
         * . .
         * . .
         * . .
         * Z=00001011010 z=00001111010
         * observation is that 5th bit is, (indexing form 0)
         * "set" in small letters
         * "unset" in capital letters
         */

        // uppercase to lowercase (setting 5th bit)
        Character A = 'A';
        Character aa = (char) (A | (1 << 5));
        System.out.println(aa); // a
        // lowercase to upper case (unsetting 5th bit)
        Character c = 'c';
        System.out.println((char) (c & (~(1 << 5)))); // C

        System.out.println((char) (1 << 5)); // space ascii value:32 ' '
        System.out.println((char) ('C' | ' ')); // c

        printBinary((int) ('_')); // 00001011111

        System.out.println((char) ('c' & '_')); // C

        /* reset upto certain no.of bits */
        int z = 59;
        printBinary(z); // 00000111011
        int i = 4;
        /*
         * i =4
         * (1<<5) === 000010000
         * (1<<5)-1 === 000001111
         * ~((1<<5)-1) == 111110000
         * 00000111011 & 111110000 == 00000100000
         */
        // after i zeroes
        int b = z & (~((1 << (i + 1)) - 1));
        printBinary(b); // 00000100000
                        // before i zeroes
        int y = (z & ((1 << (i + 1)) - 1));
        printBinary(y); // 00000011011

        // check power of 2
        int check_p = 16;
        if ((check_p & (check_p - 1)) == 1) {
            System.out.println("not power of 2");
        } else {
            System.out.println("power of 2");
        }

    }
}
