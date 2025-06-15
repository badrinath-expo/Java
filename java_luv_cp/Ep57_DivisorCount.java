public class Ep57_DivisorCount {
    public static void main(String[] args) {

        /*
         * Divisors in Programming
         * - Finding Divisors - Brute Force
         * - sqrt(N) approach
         * - Count and Sum of divisors
         * - Optimised formula for count and Sum
         */

        // Finding Divisors - Brute Force
        /*
         * int n;
         * cin >> n;
         * int count = 0;
         * int sum = 0;
         * for (int i = 1; i <= n; i++) // o(n)
         * {
         * if (n % i == 0)
         * {
         * cout << i << " ";
         * count++;
         * sum += i;
         * }
         * }
         * cout << endl;
         * cout << "sum: " << sum << " count: " << count << endl;
         */
        /* --- sqrt(N) approach ----- */
        /*
         * int n;
         * cin >> n;
         * int count = 0;
         * int sum = 0;
         * for (int i = 1; i * i <= n; i++) // (i*i <=n) <==> (i<=sqrt(n))
         * {
         * if (n % i == 0)
         * {
         * cout << i << " " << n / i << endl;
         * count += 1;
         * sum += i;
         * //let's say n=36 then, consider i=2; 2x18=36 that means 18 is also a
         * divisor, n/i is also a divisor, so add it to the sum
         * // but if n=36 then i=6, 6x6=36, so 6 is repeated, so add it only once 
         * if ((n / i) != i)
         * {
         * sum += n / i;
         * count += 1;
         * }
         * }
         * }
         * cout << "sum: " << sum << " count: " << count << endl;
         * 
         * // o(sqrt(N))
         * // if more test cases(10^6) comes it fails to execute in 10^7 ( time
         * complexity == 10^6 * sqrt(10^6) == 10^9)
         * 
         */

        /*
         * Let a number be x,
         * x=((p1)^n1)*((p2)^n2)*((p3)^n3)
         * count of divisors = (n1 + 1)(n2 + 1)(n3 + 1)
         * 36 = (2^2)*(3^2)
         * count of divisors=(2+1)(2+1)=9
         * 
         * COUNT OF DIVISORS:===
         * Let a number be x,
         * x=((p1)^n1)*((p2)^n2)*((p3)^n3)........((pt)^nt)
         * subsets of these will be divisors
         * 
         * //choices
         * count of divisors = (n1 + 1)(n2 + 1)(n3 + 1)...(nt + 1)
         * 
         * ((p1)^n1)*((p2)^n2)*((p3)^n3)........((pt)^nt)
         * SUM OF DIVISORS:==
         * (1 + p1 + p1 +....+p1^n1)x(1 + p2 + p2 +....+p2^n2)x(1 + p3 + p3
         * +....+p3^n3)x............(1 + pt + pt +....+pt^nt)
         * 
         * For 36,
         * 36 = (2^2)x(3^2)
         * p1=2 ,n1=2 p2=3,n2=2
         * (1+2+4)x(1+3+9) = (1x1)+(1x3)+(1x9)+(2x1)+(2x3)+(2x9)+(4x1)+(4x3)+(4x9)
         * = 1 + 3 + 9 + 2 + 6 + 18 + 4 + 12 + 36
         * =91
         * 
         * The above series appearing as G.P,
         * 
         * sum of divisors:===
         * (p1^(n1+1))-1 (p2^(n2+1))-1 (p2^(n2+1))-1
         * ----------------- x ----------------- x ........ x-----------------
         * p1 - 1 p2 - 1 pt - 1
         * 
         * sum of divisors:=
         * 36 = 2^2 x 3^2
         * p1=2 n1=2 p2=3 n2=2
         * 
         * 2^3 - 1 3^3 - 1
         * = ---------- ---------- = 7x13 = 91
         * 2-1 3-1
         * 
         * 24 = 2^3 x 3^1
         * p1=2 n1=3 p2=3 n2=1
         * 
         * 2^4 - 1 3^2 - 1
         * = ---------- ---------- = 15x4 = 60
         * 2-1 3-1
         * 
         */
    }
}
