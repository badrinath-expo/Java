import java.util.Scanner;

public class Ep50_SwapXOR {
    public static void main(String[] args) {
        /*
         * // swapping using xor
         * int a = 4, b = 6;
         * 
         * 
         * // xor operation
         * // 1 0 --->1
         * // 0 1 --->1
         * // 0 0 --->0
         * // 1 1 --->0
         * 
         * // x^y^z==y^z^x==x^z^y
         * 
         * a = a ^ b;
         * b = b ^ a; // b---->a
         * // b=b^(a^b) ==> b^b^a
         * a = a ^ b; // a---->b
         * // a=(a^b)^a ==>a^a^b --->b
         * 
         * cout << "a: " << a << "b: " << b << endl; // 6 4
         */

        // problem
        /*
         * interview question
         * Given array a of n integers.All integers are present in even count except one
         * .Find that one integer which has odd count in O(N) time complexity and O(1)
         * space
         * N < 10^5
         * a[i] < 10^5
         * 
         */
        int n;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            int x;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                x = sc.nextInt();
                ans ^= x;
            }
            System.out.println(ans);
            // even if we use stl library we might not get space complexity as o(1)
        }
    }
}
