package dp;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/#/description
 * Created by zrruimin on 3/30/17.
 */
public class L20170330_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int sum = sum(nums);
        if (sum % 2 > 0) {
            return false;
        }

        int half = sum >>> 1;
        return canFindPartialSum(nums, half);
    }

    private boolean canFindPartialSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = target; i >= n; i--) {
                dp[i] += dp[i - n];
            }
            if (dp[target] > 0) {
                return true;
            }
        }
        return false;
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        return sum;
    }
}

