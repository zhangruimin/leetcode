package leetcode;

/**
 */
public class L2018020102_775_Global_and_Local_Inversions {
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(i - A[i]) > 1) {
                return false;
            }
        }
        return true;
    }
}