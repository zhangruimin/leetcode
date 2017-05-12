import java.util.Stack;

/**
 * come back
 */
public class L2017051102_463_Island_Perimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                perimeter += getCellPerimeter(i, j, grid);
            }
        }
        return perimeter;
    }

    private int getCellPerimeter(int i, int j, int[][] grid) {
        if (grid[i][j] == 0) {
            return 0;
        }
        int count = 0;
        if (i == 0 || grid[i - 1][j] == 0) {
            count++;
        }

        if (j == 0 || grid[i][j - 1] == 0) {
            count++;
        }

        if (i == grid.length-1 || grid[i + 1][j] == 0) {
            count++;
        }

        if (j == grid[0].length-1 || grid[i][j + 1] == 0) {
            count++;
        }
        return count;
    }
}





