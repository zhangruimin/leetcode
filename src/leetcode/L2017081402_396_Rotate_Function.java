package leetcode;

/**
 */
public class L2017081402_396_Rotate_Function {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int l = A.length;

        int sum = 0;
        int current = 0;
        for (int i = 0; i < l; i++) {
            sum += A[i];
            current += i * A[i];
        }

        int max = current;

        for (int i = 1; i < l; i++) {
            current = current - l * A[l - i] + sum;
            max = Math.max(max, current);
        }

        return max;

    }
}

