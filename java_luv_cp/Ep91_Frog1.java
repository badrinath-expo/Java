import java.util.Arrays;
import java.util.Scanner;

public class Ep91_Frog1 {

    static final int N = (int) 1e5 + 10;
    static int h[] = new int[N];
    static int dp[] = new int[N];

    static int func(int i) {
        if (i == 0)
            return 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        int cost = Integer.MAX_VALUE;

        // way 1
        cost = Math.min(cost, func(i - 1) + Math.abs(h[i] - h[i - 1]));

        // way 2
        if (i > 1)
            cost = Math.min(cost, func(i - 2) + Math.abs(h[i] - h[i - 2]));

        return dp[i] = cost;

    } //O(N)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(dp, -1);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        System.out.println(func(n - 1)); //since we need to reach the last stone, we need to call func(n-1)
        // System.out.println(func(n-2)); // if we need to reach the second last stone, we need to call func(n-2)
        // System.out.println(func(n-3)); // if we need to reach the third last stone, we need to call func(n-3)
    }
}

/*
 * 
 * Input
 * 2
 * 10 10
 * 
 * Output:
 * 0
 */

/*
 * Input:=
 * 4
 * 10 30 40 20
 * 
 * Output:=
 * 30
 */