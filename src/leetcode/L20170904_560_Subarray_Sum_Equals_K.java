package leetcode;

import java.util.HashMap;

/**
 */
public class L20170904_560_Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSumToCount = new HashMap<>();
        preSumToCount.put(0, 1);

        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (preSumToCount.containsKey(sum - k)) {
                result += preSumToCount.get(sum - k);
            }

            Integer count = preSumToCount.getOrDefault(sum, 0);
            preSumToCount.put(sum, count + 1);
        }
        return result;
    }
}

