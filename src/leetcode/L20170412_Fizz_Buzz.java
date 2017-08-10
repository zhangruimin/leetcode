package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/problems/fizz-buzz/#/description
 */
public class L20170412_Fizz_Buzz {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            if (i % 3 == 0) {
                stringBuffer.append("Fizz");
            }
            if (i % 5 == 0) {
                stringBuffer.append("Buzz");
            }

            if (stringBuffer.length() == 0) {
                stringBuffer.append(i);
            }
            result.add(stringBuffer.toString());
        }
        return result;
    }
}

