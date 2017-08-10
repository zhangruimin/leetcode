package leetcode;

import java.util.Arrays;

/**
 */
public class L2017062901_16_3Sum_Closest {
    public static void main(String[] args) {
        int[] ints = {1,1,-1,-1,3};
        System.out.println(new L2017062901_16_3Sum_Closest().threeSumClosest(ints, -1));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public int threeSumClosest_mine(int[] nums, int target) {
        int sum = 0;
        int leastLength = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    int abs = Math.abs(sum - target);
                    if (abs < leastLength) {
                        leastLength = abs;
                        result = sum;
                    }
                }
            }
        }
        return result;

    }
}

