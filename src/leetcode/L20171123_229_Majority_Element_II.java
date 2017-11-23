package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 */
public class L20171123_229_Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        int count1 = 0;
        int count2 = 0;
        int candidate1 = nums[0];
        int candidate2 = nums[0];

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                count1++;
                candidate1 = num;
            } else if (count2 == 0) {
                count2++;
                candidate2 = num;
            } else {
                count1--;
                count2--;
            }
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                sum1++;
            }
            if (candidate2 != candidate1 && candidate2 == num) {
                sum2++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (sum1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (sum2 > nums.length / 3) {
            result.add(candidate2);
        }

        return result;
    }
}

