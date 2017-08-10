package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 */
public class L2017080901_304_Range_Sum_Query_2D_Immutable {
    public class NumMatrix {
        private int[][] sums;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                sums = new int[0][0];
                return;
            }
            int rows = matrix.length;
            int columns = matrix[0].length;

            sums = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (i == 0 && j == 0) {
                        sums[i][j] = matrix[i][j];
                    } else if (j == 0) {
                        sums[i][j] = sums[i - 1][j] + matrix[i][j];
                    } else if (i == 0) {
                        sums[i][j] = sums[i][j - 1] + matrix[i][j];
                    } else {
                        sums[i][j] = sums[i - 1][j] -sums[i-1][j-1] + sums[i][j - 1] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = sums[row2][col2];
            if (row1 > 0) {
                sum -= sums[row1 - 1][col2];
            }
            if (col1 > 0) {
                sum -= sums[row2][col1 - 1];
            }

            if (row1 > 0 && col1 > 0) {
                sum += sums[row1 - 1][col1 - 1];
            }
            return sum;
        }
    }

}

