import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/perfect-number/#/description
 * Created by zrruimin on 3/26/17.
 */
public class L20170331_Perfect_Number {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }

        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }

}

