import java.util.Scanner;

public class Ep15_preComputationII {
    public static void main(String[] args) {
        final int N = (int) 1e7 + 10;
        long arr[] = new long[N];

        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < N; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int d = scanner.nextInt();
            arr[a] += d;
            arr[b + 1] -= d;

        }

        for (int i = 1; i < N; i++) {
            arr[i] += arr[i - 1];
        }

        long maxi = -1;
        for (int i = 1; i < N; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        System.out.println(maxi);

    }
}
