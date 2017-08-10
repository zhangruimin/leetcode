package leetcode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/arithmetic-slices/#/description
 */
public class L20170407_Arithmetic_Slices {
    public int numberOfArithmeticSlices(int[] A) {
        int length = A.length;
        if (length < 3) {
            return 0;
        }

        int result = 0;

        int diff = A[1] - A[0];
        int sameDiffNum = 2;
        for (int i = 2; i < length; i++) {
            if (A[i] - A[i - 1] == diff) {
                sameDiffNum++;
            } else {
                result += calculateDiffNum(sameDiffNum);
                diff = A[i] - A[i - 1];
                sameDiffNum = 2;
            }
        }
        result += calculateDiffNum(sameDiffNum);
        return result;

    }

    private int calculateDiffNum(int sameDiffNum) {
        if (sameDiffNum < 3) {
            return 0;
        }
        return (sameDiffNum - 2) * (sameDiffNum - 1) / 2;
    }
}

