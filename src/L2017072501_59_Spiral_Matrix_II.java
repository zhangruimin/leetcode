/**
 */
public class L2017072501_59_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1;
        int max = n * n;

        int[][] result = new int[n][n];

        while(true) {
            for (int col = colStart; col <= colEnd; col++) {
                result[rowStart][col] = num++;
            }
            if (num > max) {
                break;
            }
            rowStart++;
            for (int row = rowStart; row <= rowEnd; row++) {
                result[row][colEnd]=num++;
            }
            colEnd--;

            for (int col = colEnd; col >=colStart ; col--) {
                result[rowEnd][col] = num++;
            }
            if (num > max) {
                break;
            }
            rowEnd--;

            for (int row = rowEnd; row >=rowStart ; row--) {
                result[row][colStart] = num++;
            }

            colStart++;
        }

        return result;
    }
}

