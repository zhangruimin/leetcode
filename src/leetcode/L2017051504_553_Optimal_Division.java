package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 */
public class L2017051504_553_Optimal_Division {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return Arrays.stream(nums).boxed().map(String::valueOf).collect(Collectors.joining("/"));
        }
        return nums[0]+"/("+getSecondPart(nums)+")";
    }

    private String getSecondPart(int[] nums) {
        return Arrays.stream(nums).skip(1).boxed().map(String::valueOf).collect(Collectors.joining("/"));
    }
}





