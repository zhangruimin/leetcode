import java.util.HashSet;

/**
 */
public class L2017051602_264_Ugly_Number_II {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }

        int[] uglyNums = new int[n];

        uglyNums[0] = 1;

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;

        for (int i = 1; i < n; i++) {
            int f2 = factor2 * uglyNums[index2];
            int f3 = factor3 * uglyNums[index3];
            int f5 = factor5 * uglyNums[index5];
            int min = Math.min(Math.min(f2, f3), f5);
            uglyNums[i] = min;

            if (min == f2) {
                index2++;
            }

            if (min == f3) {
                index3++;
            }
            if (min == f5) {
                index5++;
            }
        }
        return uglyNums[n - 1];

    }

    public int nthUglyNumber_mine_exceed_time_limit(int n) {
        if (n == 1) {
            return 1;
        }
        HashSet<Integer> found = new HashSet<>();
        found.add(1);
        int current = 2;
        while (true) {
            if (isUgly(found, current)) {
                if (found.size() == n - 1) {
                    return current;
                } else {
                    found.add(current);
                }
            }
            current++;
        }
    }

    private boolean isUgly(HashSet<Integer> found, int current) {
        if (current % 2 == 0 && found.contains(current / 2)) {
            return true;
        }
        if (current % 3 == 0 && found.contains(current / 3)) {
            return true;
        }
        if (current % 5 == 0 && found.contains(current / 5)) {
            return true;
        }
        return false;
    }
}





