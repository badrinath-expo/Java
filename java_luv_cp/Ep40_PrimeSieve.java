public class Ep40_PrimeSieve {

    public static void sieve(int prime[], int n) {
        for (int i = 2; i < prime.length; i++) {
            for (int j = i + i; j < prime.length; j += i) {
                prime[j] = -1;
            }
        }
    }

    public static void printPrimes(int prime[]) {
        for (int i = 0; i < prime.length; i++) {
            if (prime[i] == 0)
                System.out.println("i " + i + " " + prime[i]);
        }
    }

    public static int sqrt(int n) {
        int l = 1, r = n, ans = 0;

        while (l < r) {
            int mid = (l + r) / 2;
            if (mid * mid <= n) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 100;
        int prime[] = new int[n + 1];
        prime[0] = prime[1] = -1;
        sieve(prime, n);
        System.err.println(sqrt(36));
    }
}
