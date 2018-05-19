package leetcode;

/**
 */
public class L2018051901_835_Image_Overlap {
    public int largestOverlap(int[][] A, int[][] B) {
        return Math.max(move(A, B), move(B, A));
    }

    private int move(int[][] A, int[][] B) {
        int max = 0;
        int h = A.length;
        int w = A[0].length;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int count = 0;
                for (int k = i; k < h; k++) {
                    for (int l = j; l < w; l++) {
                        if (A[k][l] == 1 && B[k - i][l - j] == 1) {
                            count++;
                        }
                    }
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
