package leetcode;

/**
 */
public class L2017041605_326_Power_of_Three {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1 && n % 3 == 0) {
            n /= 3;
        }
        return 1 == n;
    }

    public boolean isPowerOfThree_mine(int n) {
        if (n <= 0) {
            return false;
        }

        int c = 1;
        while (c < n) {
            c = c * 3;
        }
        return c == n;
    }
}

