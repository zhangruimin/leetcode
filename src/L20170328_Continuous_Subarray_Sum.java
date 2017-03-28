import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/#/description
 * Created by zrruimin on 3/26/17.
 */
public class L20170328_Continuous_Subarray_Sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        int length = nums.length;
        int[] sums = new int[length];

        for (int i = 0; i < length; i++) {
            sums[i] = nums[i];
            for (int j = i + 1; j < length; j++) {
                sums[i] += nums[j];
                if(isMultiple(sums[i], k)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isMultiple(int sum, int k) {
        if (k == 0) {
            return sum == 0;
        }

        return sum % k == 0;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;
            }
            else map.put(runningSum, i);
        }
        return false;
    }
}

