package leetcode;

/**
 */
public class L2017041602_319_Bulb_Switcher {
    public int bulbSwitch(int n) {
        return (int)Math.floor(Math.sqrt(n));
    }
    public int bulbSwitch_mine(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int divideNum = findDivideNum(i);
            if (divideNum % 2 == 1) {
                count++;
            }
        }
        return count;
    }

    private int findDivideNum(int num) {
        if (num == 1) {
            return 1;
        }

        int result = 0;
        int i = 1;
        while (i * i <= num) {
            if (num % i == 0) {
                result += 2;
            }
            if (i * i == num) {
                result--;
            }
            i++;
        }
        return result;
    }

}

