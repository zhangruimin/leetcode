/**
 */
public class L2017041606_342_Power_of_Four {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1 && n % 4 == 0) {
            n /= 4;
        }
        return 1 == n;
    }
}

