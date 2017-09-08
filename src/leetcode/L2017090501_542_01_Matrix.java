package leetcode;

import java.util.LinkedList;

/**
 */
public class L2017090501_542_01_Matrix {
    public static void main(String[] args) {

        new L2017090501_542_01_Matrix().updateMatrix(new int[][]{{1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0}});
    }

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] result = new int[m][n];
        LinkedList<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                    queue.push(new int[]{i, j});
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int i = current[0];
            int j = current[1];
            if (i > 0 && result[i][j] + 1 < result[i - 1][j]) {
                result[i - 1][j] = result[i][j] + 1;
                queue.add(new int[]{i - 1, j});
            }

            if (i < m - 1 && result[i][j] + 1 < result[i + 1][j]) {
                result[i + 1][j] = result[i][j] + 1;
                queue.add(new int[]{i + 1, j});
            }

            if (j > 0 && result[i][j] + 1 < result[i][j - 1]) {
                result[i][j - 1] = result[i][j] + 1;
                queue.add(new int[]{i, j - 1});
            }

            if (j < n - 1 && result[i][j] + 1 < result[i][j + 1]) {
                result[i][j + 1] = result[i][j] + 1;
                queue.add(new int[]{i, j + 1});
            }
        }

        return result;
    }

    public int[][] updateMatrix_mine(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = 20000;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    recursiveSet(result, m, n, i, j, 0);
                }
            }
        }
        return result;
    }

    private void recursiveSet(int[][] result, int m, int n, int i, int j, int distance) {
        if (distance != 0 && result[i][j] <= distance) {
            return;
        }
        result[i][j] = distance;

        if (i > 0) {
            recursiveSet(result, m, n, i - 1, j, distance + 1);
        }

        if (i < m - 1) {
            recursiveSet(result, m, n, i + 1, j, distance + 1);
        }

        if (j > 0) {
            recursiveSet(result, m, n, i, j - 1, distance + 1);
        }
        if (j < n - 1) {
            recursiveSet(result, m, n, i, j + 1, distance + 1);
        }
    }
}

