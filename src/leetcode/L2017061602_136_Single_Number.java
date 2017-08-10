package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 */
public class L2017061602_136_Single_Number {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^=  num;
        }
        return result;
    }
}

