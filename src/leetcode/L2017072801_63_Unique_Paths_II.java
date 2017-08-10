package leetcode;

/**
 */
public class L2017072801_63_Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];
        dp[rows - 1][cols - 1] = 1 - obstacleGrid[rows - 1][cols - 1];
        for (int i = cols - 2; i >= 0; i--) {
            if (obstacleGrid[rows - 1][i] == 0) {
                dp[rows - 1][i] = dp[rows - 1][i + 1];
            }
        }

        for (int i = rows - 2; i >= 0; i--) {
            if (obstacleGrid[i][cols - 1] == 0) {
                dp[i][cols - 1] = dp[i + 1][cols - 1];
            }
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}

