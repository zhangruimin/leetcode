package leetcode;

/**
 */
public class L20171115_375_Guess_Number_Higher_or_Lower_II {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return recursive(dp, 1, n);
    }

    private int recursive(int[][] dp, int s, int e) {
        if (s >= e) {
            return 0;
        }

        if (dp[s][e] != 0) {
            return dp[s][e];
        }

        int min = Integer.MAX_VALUE;
        for (int i = s; i <= e; i++) {
            int current = i + Math.max(recursive(dp, s, i - 1), recursive(dp, i + 1, e));
            min = Math.min(min, current);
        }
        dp[s][e] = min;
        return min;
    }
}

