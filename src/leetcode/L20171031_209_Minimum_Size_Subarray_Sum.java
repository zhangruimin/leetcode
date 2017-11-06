package leetcode;

/**
 */
public class L20171031_209_Minimum_Size_Subarray_Sum {
    public static void main(String[] args) {
        System.out.println(new L20171031_209_Minimum_Size_Subarray_Sum().minSubArrayLen(100, new int[]{2,3,1,2,4,3}));
    }
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;
        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {
            while (fast < nums.length && sum < s) {
                sum += nums[fast];
                fast++;
            }

            while (slow <= fast && sum >= s) {
                min = Math.min(min, fast - slow);
                sum -= nums[slow];
                slow++;
            }
        }

        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        return min;

    }
}

