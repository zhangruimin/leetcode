package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class L2018022701_650_2_Keys_Keyboard {
    public int minSteps(int n) {
        int count = 0;
        int d = 2;
        while (n > 1) {
            while (n % d == 0) {
                count += d;
                n = n / d;
            }
            d++;
        }
        return count;
    }

    public int minSteps_mine(int n) {
        if (n == 1) {
            return 0;
        }
        List<Integer> commons = getCommons(n);
        int min = Integer.MAX_VALUE;
        for (Integer common : commons) {
            min = Math.min(n / common + minSteps(common), min);
        }

        return min;
    }

    private List<Integer> getCommons(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                result.add(i);
                if (i != 1) {
                    result.add(n / i);
                }
            }
        }
        return result;
    }
}
