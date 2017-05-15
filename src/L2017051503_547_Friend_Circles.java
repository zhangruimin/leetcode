/**
 */
public class L2017051503_547_Friend_Circles {
    public int findCircleNum(int[][] M) {
        int length = M.length;

        boolean[] counted = new boolean[length];
        int circles = 0;

        for (int i = 0; i < length; i++) {
            if (!counted[i]) {
                circles ++;
                countForRow(M, i, counted);
            }
        }

        return circles;

    }

    private void countForRow(int[][] m, int row, boolean[] counted) {
        counted[row] = true;
        for (int j = 0; j < m[0].length; j++) {
            if (m[row][j] == 1 && !counted[j]) {
                countForRow(m, j, counted);
            }
        }
    }
}





