package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 */
public class L2017041501_376_Wiggle_Subsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxLength = 1;

        int i = 1;
        while (i < nums.length && nums[i] == nums[i - 1]) {
            i++;
        }
        if (i == nums.length) {
            return maxLength;
        }

        boolean increasing = nums[i] > nums[i - 1];
        maxLength++;
        i++;

        while (i < nums.length) {
            if(increasing){
                if(nums[i]<nums[i-1]){
                    maxLength++;
                    increasing = false;
                }
            } else{
                if(nums[i]>nums[i-1]){
                    maxLength++;
                    increasing = true;
                }
            }
            i++;
        }
        return maxLength;

    }

}

