package leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 */
public class L2017050302_532_K_diff_Pairs_in_an_Array {

    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() > 1) {
                    count++;
                }
            } else {
                if (map.get(entry.getKey() + k) != null) {
                    count++;
                }
            }
        }
        return count;
    }
    public int findPairs_mine(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);

        int left = 0;
        int right = 1;

        if (k == 0) {
            return findPairsFor0(nums);
        }

        k = Math.abs(k);
        while (right < nums.length) {
            while (nums[right] - nums[left] > k && left < right) {
                left++;
            }

            if (nums[right] - nums[left] == k) {
                count++;
            }

            while (right + 1 < nums.length && nums[right + 1] == nums[right]) {
                right++;
            }

            right++;
        }
        return count;
    }

    private int findPairsFor0(int[] nums) {
        int count = 0;
        boolean isFirst = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (isFirst) {
                    count++;
                }
                isFirst = false;
            } else {
                isFirst = true;
            }
        }
        return count;
    }
}





