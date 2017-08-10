package leetcode;

/**
 * https://leetcode.com/problems/is-subsequence/#/description
 */
public class L20170405_Perfect_Squares {
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            int j = 1;
            while (i - j * j >= 0) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                j++;
            }
        }
        return dp[n];
    }
}

