import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ep60_PrimeSums {
    public static void main(String[] args) {
        final int N = (int) 1e7;
        boolean isPrime[] = new boolean[N];

        for (int i = 0; i < N; i++) {
            isPrime[i] = true;
        }

        int hp[] = new int[N];
        int lp[] = new int[N];

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < N; i++) {
            if (isPrime[i]) {

                lp[i] = hp[i] = i;

                for (int j = 2 * i; j < N; j += i) {
                    isPrime[j] = false;
                    hp[j] = i;
                    if (lp[j] == 0) {
                        lp[j] = i;
                    }
                }
            }
        }

        for (int i = 1; i < N; i++) {
            System.out.println(i + " " + lp[i] + " " + hp[i]);
        }

        // *** Prime Factorisation ***
        int num = 30;
        // vector<int> prime_factors;
        Map<Integer, Integer> prime_factors = new HashMap<>();
        while (num > 1) {
            int prime_factor = hp[num];
            while (num % prime_factor == 0) {
                num /= prime_factor;
                prime_factors.put(prime_factor, prime_factors.getOrDefault(prime_factor, 0) + 1);
            }
        } // logN

        for (Map.Entry<Integer, Integer> factor : prime_factors.entrySet()) {
            System.out.println(factor.getKey() + " " + factor.getValue());
        }

        // *** Divisors Variation using sieve ***

        ArrayList<Integer> divisors[] = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            divisors[i] = new ArrayList<>();
        }
        int sum[] = new int[N];

        for (int i = 2; i < N; i++) {
            for (int j = i; j < N; j += i) {
                divisors[j].add(i);
                sum[j] += i;
            }
        } // nlogn

        /*
         * Time Complexity of above for loop
         * (n/2)+ (n/3)+ (n/4)+ (n/5)+...... (n/n)
         * 
         * 
         * n((1/2)+ (1/3)+ (1/4)+ (1/5).....+1)
         * = nLog(n)
         */

        for (int i = 1; i < 10; i++) {

            for (int div : divisors[i]) {
                System.out.print(div + " ");
            }
            System.out.println();
        }

    }
}
