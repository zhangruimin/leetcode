package leetcode;

/**
 */
public class L2018011801_764_Largest_Plus_Sign {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
//        System.out.println(new L2018011801_764_Largest_Plus_Sign().orderOfLargestPlusSign(5, new int[][]{{4,2}}));
    }
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] isZeroPosition = new int[N][N];
        for (int[] row : mines) {
            isZeroPosition[row[0]][row[1]] = 1;
        }
        int[][] left = new int[N][N];
        int[][] right = new int[N][N];
        int[][] upper = new int[N][N];
        int[][] down = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isZeroPosition[i][j] == 0) {
                    left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;
                    upper[i][j] = i > 0 ? upper[i - 1][j] + 1 : 1;
                }

                if (isZeroPosition[N - 1 - i][N - 1 - j] == 0) {
                    right[N - 1 - i][N - 1 - j] = j > 0 ? right[N - 1 - i][N - j] + 1 : 1;
                    down[N - 1 - i][N - 1 - j] = i > 0 ? down[N - i][N - 1 - j] + 1 : 1;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int min = Math.min(left[i][j], Math.min(right[i][j], Math.min(upper[i][j], down[i][j])));
                max = Math.max(max, min);
            }
        }
        return max;

    }
}

