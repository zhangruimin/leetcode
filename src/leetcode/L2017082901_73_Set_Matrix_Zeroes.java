package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 */
public class L2017082901_73_Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        int rNum = matrix.length;
        int cNum = matrix[0].length;
        boolean isColumn0Zero = false;
        for (int i = 0; i < rNum; i++) {
            if (matrix[i][0] == 0) {
                isColumn0Zero = true;
            }
        }

        for (int i = 0; i < rNum; i++) {
            for (int j = 1; j < cNum; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for (int row = rNum - 1; row >= 0; row--) {
            for (int col = cNum - 1; col > 0; col--) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
            if (isColumn0Zero) {
                matrix[row][0] = 0;
            }
        }
    }

    public void setZeroes_mine(int[][] matrix) {
        int rNum = matrix.length;
        int cNum = matrix[0].length;
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();

        for (int i = 0; i < rNum; i++) {
            for (int j = 0; j < cNum; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (Integer row : rowSet) {
            Arrays.fill(matrix[row], 0);
        }

        for (Integer col : colSet) {
            for (int i = 0; i < rNum; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}

