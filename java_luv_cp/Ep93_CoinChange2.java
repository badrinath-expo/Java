import java.util.Arrays;

public class Ep93_CoinChange2 {

    static final int N = (int) 1e4 + 10;
    static int dp[][] = new int[310][N];

    static int func(int index, int amount, int coins[]) {

        if (amount == 0)
            return 1;

        if (index < 0)
            return 0;
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int ways = 0;

        for (int coin_amount = 0; coin_amount <= amount; coin_amount += coins[index]) {
            ways += func(index - 1, (amount - coin_amount), coins);
        }

        return dp[index][amount] = ways;
    }

    static int coinChange(int[] coins, int amount) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return func(coins.length - 1, amount, coins);
    }

    public static void main(String[] args) {

        int amount = 5;

        int coins[] = { 1, 2, 5 };

        int ans = coinChange(coins, amount); //4
        System.out.println(ans);
    }
}
