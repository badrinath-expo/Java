import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;

public class Ep58_primeFactors {

    public static void main(String[] args) {
        /*
         * Primes
         * -Finding Primes
         * -Sqrt(N) approach
         * -Prime Factorization
         */

        /*
         * bool is_prime = true;
         * int n;
         * cin >> n;
         * // if (n == 1)
         * // {
         * // cout << 0 << endl;
         * // }
         * for (int i = 2; i < n; i++)
         * {
         * if (n % i == 0)
         * {
         * is_prime = false;
         * break;
         * }
         * } // O(N)
         * for (int i = 2; i <= sqrt(n); i++) // i<=sqrt(n)<==>i*i < n
         * {
         * if (n % i == 0)
         * {
         * is_prime = false;
         * break;
         * }
         * } // O(root(N))
         * cout << is_prime << endl;
         */
        /*
         * Let the number be 36
         * 1x36
         * 2x18
         * 3x12
         * 4x9
         * 6x6
         * --------------
         * 9x4
         * 12x3
         * 18x2
         * 36x1
         * 
         * 
         * we can optimise the previous O(N) by finding from 1 to root(N)
         * 
         * let 2x18,we were checking 2 is a factor of 36,it is obvious that 18 also be
         * the factor of 36
         */
        int n = 10;

        ArrayList<Integer> prime_factors = new ArrayList<Integer>();
        /*
         * for (int i = 2; i <= n; i++)
         * {
         * cout << "For n: " << n << " i: " << i << endl;
         * 
         * while (n % i == 0)
         * {
         * prime_factors.push_back(i);
         * n /= i;
         * cout << "while n: " << n << " i: " << i << endl;
         * }
         * }//O(N)
         */

        for (int i = 2; i <= Math.sqrt(n); i++) {
            System.out.print("For n: " + n + " i: " + i);

            while (n % i == 0) {
                prime_factors.add(i);
                n /= i;
                System.out.print("while n: " + n + " i: " + i);
            }
        }
        /*
         * For sqrt(n) logic:=
         * let n=24
         * first i=2,
         * i continuously dividing until n/2==0
         * 24---12---6
         * later the updated n value is n/8 ==>n=3
         * 
         * The For loop iterates from 2 to sqrt(3)(=1.7)
         * 
         * so it won't consider 3,For this condition we kept the following if condition
         */
        if (n > 1) {
            prime_factors.add(n);
        }

        for (int prime : prime_factors) {
            System.out.print(prime + " ");
        }
    }
}
