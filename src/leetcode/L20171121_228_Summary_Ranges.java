package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class L20171121_228_Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                if (nums[i - 1] > start) {
                    result.add(start + "->" + nums[i - 1]);
                } else {
                    result.add(String.valueOf(start));
                }
                start = nums[i];
            }
        }

        if (nums[nums.length - 1] > start) {
            result.add(start + "->" + nums[nums.length - 1]);
        } else {
            result.add(String.valueOf(start));
        }
        return result;
    }
}

