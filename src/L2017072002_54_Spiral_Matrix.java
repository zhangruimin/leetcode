import java.util.ArrayList;
import java.util.List;

/**
 */
public class L2017072002_54_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        int maxRounds = Math.min((matrix.length + 1) / 2, (matrix[0].length + 1) / 2);
        for (int i = 0; i < maxRounds; i++) {
            if (i < matrix.length - i - 1 && i < matrix[0].length - i - 1) {
                addRound(i, matrix, result);
            }else  if (i == matrix.length - i - 1 ) {
                addRow(i, matrix, result);
            }else  if (i == matrix[0].length - i - 1 ) {
                addColumn(i, matrix, result);
            }
        }
        return result;
    }

    private void addColumn(int col, int[][] matrix, ArrayList<Integer> result) {
        for (int row = col; row < matrix.length - col; row++) {
            result.add(matrix[row][col]);
        }
    }

    private void addRow(int row, int[][] matrix, ArrayList<Integer> result) {
        for (int col = row; col < matrix[0].length - row; col++) {
            result.add(matrix[row][col]);
        }
    }

    private void addRound(int round, int[][] matrix, ArrayList<Integer> result) {
        for (int col = round; col < matrix[0].length - round; col++) {
            result.add(matrix[round][col]);
        }

        for (int row = round + 1; row < matrix.length - round - 1; row++) {
            result.add(matrix[row][matrix[0].length - round - 1]);
        }

        for (int col = matrix[0].length - round - 1; col >= round; col--) {
            result.add(matrix[matrix.length-round -1][col]);
        }

        for (int row = matrix.length - round - 2; row >= round + 1; row--) {
            result.add(matrix[row][round]);
        }
    }
}

