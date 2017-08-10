package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class L2017071702_89_Gray_Code {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        double max = Math.pow(2, n);
        for (int i = 0; i <max; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }
}

