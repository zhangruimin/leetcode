package leetcode;

/**
 */
public class L2018042301_790_Domino_and_Tromino_Tiling {
    public int numTilings(int N) {
        int MOD = 1000000007;
        if (N == 0) {
            return 0;
        }

        if (N == 1) {
            return 1;
        }

        if (N == 2) {
            return 2;
        }

        int p1 = 2;
        int p2 = 1;
        int p3 = 1;
        for (int i = 3; i <= N; i++) {
            int current = (int)((p1 + p2 + 2L * p3)%MOD);
            p3 = (p2 + p3)%MOD;
            p2 = p1;
            p1 = current;
        }
        return p1;
    }

    public int numTilings_recursive(int N) {
        int MOD = 1000000007;
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        int[][] dp = new int[2][N + 1];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[1][2] = 1;
        recursive(N, dp, MOD);
        return dp[0][N];
    }

    private void recursive(int n, int[][] dp, int MOD) {
        if (dp[0][n] > 0) {
            return;
        }

        recursive(n - 1, dp, MOD);
        recursive(n - 2, dp, MOD);
        recursiveWithTromino(n - 1, dp, MOD);
        dp[0][n] = (int)((dp[0][n - 1] + dp[0][n - 2] + 2L * dp[1][n - 1]) % MOD);
    }

    private void recursiveWithTromino(int l, int[][] dp, int MOD) {
        if (l <= 1) {
            return;
        }

        if (dp[1][l] > 0) {
            return;
        }

        recursive(l - 2, dp, MOD);
        recursiveWithTromino(l - 1, dp, MOD);
        dp[1][l] = (dp[0][l - 2] + dp[1][l - 1]) % MOD;
    }
}
