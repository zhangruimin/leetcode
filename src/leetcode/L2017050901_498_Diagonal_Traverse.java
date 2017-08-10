package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 */
public class L2017050901_498_Diagonal_Traverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int length = matrix.length;
        int width = matrix[0].length;

        int[] result = new int[length * width];

        int index = 0;

        boolean isUp = true;
        for (int i = 0; i <= length + width - 2; i++) {
            for (int j = 0; j <= i; j++) {
                if (isUp) {
                    if (i - j < length && j < width) {
                        result[index++] = matrix[i - j][j];
                    }
                } else {
                    if (j < length && i - j < width) {
                        result[index++] = matrix[j][i - j];
                    }
                }
            }
            isUp = !isUp;
        }
        return result;
    }}





