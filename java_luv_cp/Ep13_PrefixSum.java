import java.util.Scanner;

public class Ep13_PrefixSum {

    public static void prefixSum1DArray() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            final int N = (int) 1e5 + 10;
            int a[] = new int[N];
            int pf[] = new int[N];

            // prefix sum array
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
                pf[i] = pf[i - 1] + a[i];
            }

            int q = scanner.nextInt();

            while (q != 0) {
                int l = scanner.nextInt(), r = scanner.nextInt();

                System.out.println(pf[r] - pf[l - 1]); // since in pf[l] the (element at index 'l') is added and also in the
                                                       // index 'r' (element at index 'l') is previously added to avoid one
                                                       // more adding of (element at index 'l') we are performing
                                                       // pf[r]-pf[l-1]

                // or we can write like this:=
                // pf[r]-pf[l]+a[l] ==> pf[r]-(pf[l]-a[i]) ==> (pf[l]-a[l]) is equals to p[l-1]
                // ===> pf[r]-pf[l-1]
                q--;
            }
        }
    }

    public static void prefixSum2DArray(int arr[][], int pf[][]){
      Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = scanner.nextInt();
                pf[i][j] = arr[i][j] + pf[i - 1][j] + pf[i][j - 1] - pf[i - 1][j - 1];
            }
        }


        int q = scanner.nextInt();
        while (q != 0) {
            int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), d = scanner.nextInt();
            System.out.println(pf[c][d] - pf[c][b-1] - pf[a-1][d] + pf[a - 1][b - 1]);
            q--;
        }
        scanner.close();
    }

    public static void main(String[] args) {
    }
}
