import java.util.Arrays;
import java.util.Scanner;

public class Ep93_CoinChange1 {
    static final int N = (int) 1e4 + 10;
    static int dp[] = new int[N];

    static int func(int amount, int coins[]) {
        if (dp[amount] != -1) {
            return dp[amount];
        }
        if (amount == 0)
            return 0;
        int ans = Integer.MAX_VALUE;

        for (int coin : coins) {
            if ((amount - coin) >= 0)
                ans = (int) Math.min(ans + 0L, func((amount - coin), coins) + 1L); // +1 is one coin used, performing
                                                                                   // operation in long to handle
                                                                                   // overflow
        }

        return dp[amount] = ans;
    }

    static int coinChange(int[] coins, int amount) {
        Arrays.fill(dp, -1);
        int ans = func(amount, coins);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int amount = sc.nextInt();
        int coins[] = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int ans = coinChange(coins, amount);
        System.out.println(ans);
    }
}

/*
 * Input:=
 * 3 11
 * 1 2 5
 * 
 * Output
 * 3
 */

/*
 * Input:=
 * 1 3
 * 2
 * 
 * Output:=
 * -1
 */