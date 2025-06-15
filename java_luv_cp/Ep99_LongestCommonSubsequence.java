import java.util.Arrays;

public class Ep99_LongestCommonSubsequence {
    static final int N = (int) 1e5 + 10;
    static int dp[][] = new int[1005][1005];

    static int lcs(int i, int j, String s1, String s2) {

        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        // remove 1 char from s1
        int ans = lcs(i - 1, j, s1, s2);
        // remove 1 char from s2
        ans = Math.max(ans, lcs(i, j - 1, s1, s2));
        // remove 1 char from both s1 and s2
        ans = Math.max(ans, lcs(i - 1, j - 1, s1, s2) + (s1.charAt(i) == s2.charAt(j) ? 1 : 0));
        return dp[i][j] = ans;
    }

    static int longestCommonSubsequence(String text1, String text2) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return lcs(text1.length() - 1, text2.length() - 1, text1, text2);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace")); // 3
        System.out.println(longestCommonSubsequence("bsbininm", "jmjkbkjkv")); // 1
    }
}
