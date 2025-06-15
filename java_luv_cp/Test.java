public class Test {

    static int coinChange(int[] coins, int amount, int index) {

        if (amount == 0)
            return 1;
        if (index < 0) {
            return 0;
        }

        int ways = 0;

        for (int coin_amount = 0; coin_amount <= amount; coin_amount += coins[index]) {
            if (amount - coin_amount >= 0)
                ways += coinChange(coins, amount - coin_amount, index - 1);
        }

        return ways;

    }

    public static void main(String[] args) {
        // knapsack1
        int coins[] = { 1, 2, 5 };

        int amount = 11;

        int ans = coinChange(coins, amount, coins.length - 1);

        System.out.println(ans);
    }
}
