package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 */
public class L2017041802_367_Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;

        while (left <= right) {
            long mid = (left + right) >>> 1;
            int product = (int) (mid * mid);
            if (product == num) {
                return true;
            } else if (product < num) {
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare_mine(int num) {
        if (num < 1) {
            return false;
        }
        long left = 1;
        long right = num;

        while (left <= right) {
            long mid = (left + right) / 2;
            long product = mid * mid;
            if (product == num) {
                return true;
            }

            if (product < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}


