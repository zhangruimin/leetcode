package dp.ZeroOnePack;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/ones-and-zeroes/#/description
 * Created by zrruimin on 3/26/17.
 */
public class L20170331_Ones_and_Zeroes {
    public static void main(String[] args) {

    }
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        if (length == 0) {
            return 0;
        }

        int[][] size = getSize(strs);
        int[][] max = new int[length][3];

        if (size[0][0] < m && size[0][1] < n) {
            max[0][0] = 1;
            max[0][1] = size[0][0];
            max[0][2] = size[0][1];
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (max[j][1] + size[i][0] > m || max[j][2] + size[i][1] > n){
                    continue;
                }
                if (max[i][0] < max[j][0] + 1) {
                    max[i][0] = max[j][0] + 1;
                    max[i][1] = max[j][1] + size[i][0];
                    max[i][2] = max[j][2] + size[i][1];
                }
            }
        }

        return findMaxNum(max);
    }

    private int[][] getSize(String[] strs) {
        int[][] result = Arrays.stream(strs).map(s -> {
            int[] size = new int[2];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    size[0]++;
                } else {
                    size[1]++;
                }
            }
            return size;
        }).toArray(int[][]::new);
        return result;
    }

    private int findMaxNum(int[][] array) {
        return Arrays.stream(array).max(Comparator.comparing(a -> a[0])).get()[0];
    }
}

