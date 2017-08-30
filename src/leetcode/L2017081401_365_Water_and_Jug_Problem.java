package leetcode;

/**
 */
//come back
public class L2017081401_365_Water_and_Jug_Problem {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }

        if (z == x || z == y || z == x + y) {
            return true;
        }

        if (x == y) {
            return false;
        }

        int gcd = getGCD(x, y);
        return z % gcd == 0;
    }

    private int getGCD(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x= temp;
        }
        return x;
    }
}

