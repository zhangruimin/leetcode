package leetcode;

/**
 */
public class L2017101602_96_Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                count += dp[j] * dp[i - 1 - j];
            }
            dp[i] = count;
        }
        return dp[n];

    }
}

