import java.util.Scanner;

public class Ep12_HashingPrecomputation {

    public static void main(String[] args) {

        // factorial
        // Scanner scanner = new Scanner(System.in);

        // final int M = (int) 1e9 + 7;
        // final int N = (int) 1e5 + 10;
        // long fact[] = new long[N];

        // fact[0] = fact[1] = 1;

        // for (int i = 2; i < N; i++) {

        // fact[i] = (fact[i - 1] * i) % M;

        // }

        // int t = scanner.nextInt(); // test cases

        // while (t != 0) {
        // int n = scanner.nextInt();
        // System.out.println(fact[n]);
        // t--;
        // }
        // scanner.close();

        // hashing
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int hshArray[] = new int[(int) 1e7 + 10];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            hshArray[arr[i]]++;
        }
        int q = scanner.nextInt();
        while (q != 0) {
            int x = scanner.nextInt();
            System.out.println(hshArray[x]);
            q--;
        }
        scanner.close();
    }
}
