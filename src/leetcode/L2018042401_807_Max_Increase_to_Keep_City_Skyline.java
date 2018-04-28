package leetcode;

/**
 */
public class L2018042401_807_Max_Increase_to_Keep_City_Skyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int h = grid.length;
        int w = grid[0].length;

        int[] s1 = new int[h];
        int[] s2 = new int[w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                s1[i] = Math.max(s1[i], grid[i][j]);
                s2[j] = Math.max(s2[j], grid[i][j]);
            }
        }

        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                count += Math.min(s1[i], s2[j]) - grid[i][j];
            }
        }
        return count;
    }
}
