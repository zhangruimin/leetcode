package leetcode;

/**
 */
public class L2017080301_74_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = binaryLocateRow(matrix, target);
        return binarySearch(matrix[row], target);
    }

    private boolean binarySearch(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (row[mid] < target) {
                left = mid + 1;
            } else if (row[mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private int binaryLocateRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right && matrix[left][0] <= target) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Math.max(0, left - 1);
    }
}

