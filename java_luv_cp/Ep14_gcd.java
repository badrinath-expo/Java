import java.util.Scanner;

public class Ep14_gcd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(gcd(n, m));
        scanner.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int exclueLRGcd() {
        // Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        // int q = scanner.nextInt();
        // int a[] = new int[n + 10];
        // int forward[] = new int[n + 10]; // which stores the gcd from 0 to l-1

        // int backward[] = new int[n + 10]; // which stores the gcd from n to r+1
        // forward[0] = backward[n + 1] = 0;
        // for (int i = 1; i <= n; ++i) {
        // a[i] = scanner.nextInt();
        // }
        // for (int i = 1; i <= n; ++i) {
        // forward[i] = gcd(forward[i - 1], a[i]);
        // }
        // for (int i = n; i >= 1; --i) {
        // backward[i] = gcd(backward[i + 1], a[i]);
        // }
        // while (q-- > 0) {
        // int l, r;
        // l = scanner.nextInt();
        // r = scanner.nextInt();

        // System.out.println(gcd(forward[l - 1], backward[r + 1]));
        // }
        // }

        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            while (t != 0) {
                t--;
                int n = scanner.nextInt(), q = scanner.nextInt();
                int a[] = new int[n + 10];
                int forward[] = new int[n + 10]; // which stores the gcd from 0 to l-1

                int backward[] = new int[n + 10]; // which stores the gcd from n to r+1
                forward[0] = backward[n + 1] = 0;
                for (int i = 1; i <= n; ++i) {
                    a[i] = scanner.nextInt();
                }
                for (int i = 1; i <= n; ++i) {
                    forward[i] = gcd(forward[i - 1], a[i]);
                }
                for (int i = n; i >= 1; --i) {
                    backward[i] = gcd(backward[i + 1], a[i]);
                }
                while (q != 0) {
                    q--;
                    int l = scanner.nextInt(), r = scanner.nextInt();

                    System.out.println(gcd(forward[l - 1], backward[r + 1])); // gcd of the elements from 0 to l-1 and n
                                                                              // to r+1
                }
            }
        }
        return 0;
    }

}