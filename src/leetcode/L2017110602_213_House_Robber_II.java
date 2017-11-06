package leetcode;

/**
 */
public class L2017110602_213_House_Robber_II {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int low, int high) {
        int evenSum = 0;
        int oddSum = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 == 0) {
                evenSum = Math.max(evenSum + nums[i], oddSum);
            }else{
                oddSum = Math.max(oddSum + nums[i], evenSum);
            }
        }
        return Math.max(evenSum, oddSum);

    }
}

