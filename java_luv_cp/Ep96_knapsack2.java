import java.util.Arrays;
import java.util.Scanner;

public class Ep96_knapsack2 {
    static final int N = (int) 2e5 + 10;
    static int wt[] = new int[105];
    static int val[] = new int[105];
    static long dp[][] = new long[105][100005];

    static long func(int index, int value_left) {
        if (value_left == 0) // func(index, 0)
            return 0;
        if (index < 0) // func(-1, value_left), []
            return (int) 1e15; // min weight should be undefined, that's why we're returning maximum value

        if (dp[index][value_left] != -1)
            return dp[index][value_left];

        long ans = func(index - 1, value_left); // Not chosen weight at index
        if (value_left - val[index] >= 0)
            ans = Math.min(ans, func(index - 1, value_left - val[index]) + wt[index]); // weight choosen at index
        return dp[index][value_left] = ans;
    }

    public static void main(String[] args) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt();
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }

        int max_value = (int) 1e5;

        for (int i = max_value; i >= 0; i--) {
            if (func(n - 1, i) <= w) { // func(n-1,i) :: minimum weight to consider n-1 indexes with values
                System.out.println(i);
                break; // Since we want to return maximum value, the for loop is running from max value
                       // to 0
            }
        }
    }
}

/*
 * 
 * Input:=
 * 3 8
 * 3 30
 * 4 50
 * 5 60
 * 
 * Output:=
 * 90
 * 
 */