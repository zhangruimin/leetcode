package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 */
public class L2017051505_453_Minimum_Moves_to_Equal_Array_Elements {

    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }

        final int m = min;
        int reduce = Arrays.stream(nums).reduce(0, (a, b) -> a + b - m);
        return reduce;
    }
    public int minMoves_mine(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            count += (nums[i] - nums[0]);
        }
        return count;
    }
}





