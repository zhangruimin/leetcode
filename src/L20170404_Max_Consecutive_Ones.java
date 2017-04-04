/**
 * https://leetcode.com/problems/max-consecutive-ones/#/description
 */
public class L20170404_Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currentMax = 0;
        for (int n : nums) {
            if (n == 0) {
                max = Math.max(max, currentMax);
                currentMax = 0;
            } else {
                currentMax ++;
            }
        }

        max = Math.max(max, currentMax);

        return max;
    }
}

