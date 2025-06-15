import java.util.Scanner;

public class Ep51_BitMask {

    void printBinary(int num) {
        for (int i = 31; i >= 0; --i) {
            System.out.print((num >> i) & 1);
        }
        System.out.println();
    }

    public static int countSetBitCount(int n) {
        int ct = 0;

        for (int i = 31; i >= 0; i--) {
            if (((n >> i) & 1) != 0) {
                ct++;
            }
        }
        return ct;
    }

    public static void main(String[] args) {

        /*
         * Let fruits be the index as below:=
         * Apple - 0
         * Orange - 1
         * Banana - 2
         * Lichi - 3
         * bit mask
         * person1 - 2,3 ----> 1100 -- 12
         * person2 - 0,1,2 ----> 0111 -- 7
         * person3 - 1,3 ----> 1010 -- 10
         * 
         * // if two sorted arrays are given we can able to get the intersection of
         * those arrays in O(N) (two pointer approach)
         * 
         * Intersection:=
         * 1100
         * & 0111
         * -------
         * 0100 ==> 2 2nd fruit is common
         * 
         * u.int - 32 bit
         * u.long long - 64 bit limitation of bitmask
         * 
         * 
         * 
         * 
         */
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int masks[] = new int[n];
        for (int i = 0; i < n; i++) {
            int num_workers = sc.nextInt();
            int mask = 0;
            for (int x = 0; x < num_workers; x++) {
                int day = sc.nextInt();
                mask = (mask | (1 << day));
            }
            masks[i] = mask;
        }

        /*
         * for (int i = 0; i < n; i++)
         * {
         * cout << masks[i] << endl;
         * printBinary(masks[i]);
         * }
         * 
         * 658
         * 01010010010
         * 570425990
         * 01010000110
         * 545262226
         * 01010010010
         * 1345062788
         * 11110000100
         * 536873090
         * 00010000010
         */
        /*
         * for (int i = 0; i < n; i++)
         * {
         * for (int j = i + 1; j < n; j++)
         * {
         * int intersection = (masks[i] & masks[j]);
         * int common_days = __builtin_popcount(intersection);
         * cout << i << " " << j << " " << common_days << endl;
         * }
         * 
         * 0 1 3
         * 0 2 4
         * 0 3 2
         * 0 4 2
         * 1 2 4
         * 1 3 3
         * 1 4 3
         * 2 3 2
         * 2 4 4
         * 3 4 1
         * 
         * 
         * 
         * }
         */
        int max_days = 0;
        int person1 = -1;
        int person2 = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int intersection = (masks[i] & masks[j]); // & - O(1)
                int common_days = countSetBitCount(intersection); // O(1)
                if (common_days > max_days) {
                    max_days = common_days;
                    person1 = i;
                    person2 = j;
                }
            }
        }

        System.out.println(person1 + " " + person2 + " " + max_days);

    }

    /*
     * INput:=
     * 5
     * 4
     * 1 4 7 9
     * 6
     * 2 9 1 7 25 29
     * 7
     * 1 23 4 7 9 11
     * 29
     * 10
     * 2 28 8 7 9 10 30 21 18 19
     * 4
     * 1 11 29 7
     * 
     * Output:=
     * 0 2 4
     * 
     * O(N^2)
     * 
     * 
     */
}
