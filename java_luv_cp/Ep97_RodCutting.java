import java.util.Arrays;

public class Ep97_RodCutting {
    static final int N = (int) 1e5 + 10;
    static int dp[] = new int[1005];

    static int func(int len, int prices[]) {
        if (len == 0)
            return 0;
        if (dp[len] != -1)
            return dp[len];

        int ans = 0;
        for (int lengthToCut = 1; lengthToCut <= prices.length; lengthToCut++) {// cutting the rod until the max length
            if (len - lengthToCut >= 0) {
                ans = Math.max(ans, func(len - lengthToCut, prices) + prices[lengthToCut - 1]);// since prices array is 0 based indexing
            }
        }
        return dp[len] = ans;
    } //O(N^2)

    static int cutRod(int price[], int n) {
        Arrays.fill(dp, -1);
        int prices[] = new int[price.length];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = price[i];
        }
        return func(n, prices);
    }

    // refer Ep94 notes
    public static void main(String[] args) {
        int n = 8;
        int prices[] = { 1, 5, 8, 9, 10, 17, 17, 20 };

        System.out.println(cutRod(prices, n)); // 22
    }
}
