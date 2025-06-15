public class Ep24_Maths {
    // Sieve of Eratosthenes : O(n loglogn)
    // Homework: Segmented sieve

    static int gcd(int a, int b) {

        while (a != b) {
            if (a == 0)
                return b;
            if (b == 0)
                return a;
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    int modularExponentiation(int x, int n, int m) {
        int res = 1;

        while (n > 0) {
            if ((n & 1) == 1) {
                res = (int) ((res % m) * 1L * (x % m)) % m;
            }

            x = ((x % m) * (x % m)) % m;

            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(gcd(48, 24));
    }
}
