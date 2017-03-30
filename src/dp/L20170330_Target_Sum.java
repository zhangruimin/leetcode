package dp;

/**
 * https://leetcode.com/problems/target-sum/#/description
 * Created by zrruimin on 3/26/17.
 */
public class L20170330_Target_Sum{
    public static void main(String[] args) {
        int[] nums = {1, 999999};
        new L20170330_Target_Sum().findTargetSumWays(nums, 1000000);
    }
    public int findTargetSumWaysRecursive(int[] nums, int S) {
        return recursive(nums, 0, S);
    }

    private int recursive(int[] nums, int start, int S) {
        if (start == nums.length){
            return S == 0 ? 1 : 0;
        }

        return recursive(nums, start + 1, S - nums[start]) +  recursive(nums, start + 1, S + nums[start]);
    }

    public int findTargetSumWays(int[] nums, int S) {
        int sum = sum(nums);
        if ((sum + S) % 2 != 0) {
            return 0;
        }

        int pSum = (sum + S) / 2;
        if (sum < pSum) {
            return 0;
        }
        return findPositiveSumWays(nums, pSum);
    }

    private int findPositiveSumWays(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}

