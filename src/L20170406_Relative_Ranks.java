import java.util.*;

import static java.util.Comparator.comparing;

/**
 * https://leetcode.com/problems/next-greater-element-i/#/description
 */
public class L20170406_Relative_Ranks {
    public String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int higherNum = 0;
            for (int num2 : nums) {
                if (num2 > num) {
                    higherNum++;
                }
            }
            switch (higherNum) {
                case 0:
                    result[i] = "Gold Medal";
                    break;
                case 1:
                    result[i] = "Silver Medal";
                    break;
                case 2:
                    result[i] = "Bronze Medal";
                    break;
                default:
                    result[i] = "" + (higherNum + 1);
            }
        }
        return result;
    }
}

