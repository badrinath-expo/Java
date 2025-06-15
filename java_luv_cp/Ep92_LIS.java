import java.util.Arrays;
import java.util.Scanner;

public class Ep92_LIS {
    static final int N = (int) 25e2 + 10;
    static int a[] = new int[N];
    static int dp[] = new int[N];

    // lis(i) means Longest Increasing subsequence ending at ith element
    static int lis(int i) {
        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = 1; // since whatever index is there, that element could be only one element for the
                     // LIS until this index
        for (int j = 0; j < i; j++) {
            if (a[i] > a[j]) {
                ans = Math.max(ans, lis(j) + 1); // +1 means considering the chosen index's element
            }
        }
        return dp[i] = ans;
    } // O(N)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(dp, -1);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("i:" + i + "  lis(" + i + ") " + lis(i));
            ans = Math.max(ans, lis(i)); // maximum length for lis for every every index
        }

        System.out.println(ans);
    }
}

/*
 * Input:=
 * 8
 * 10 9 2 5 3 7 101 18
 * 
 * Output:=
 * 4
 */
