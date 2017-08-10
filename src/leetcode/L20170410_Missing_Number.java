package leetcode;

/**
 * https://leetcode.com/problems/missing-number/#/description
 */
public class L20170410_Missing_Number {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = (length * (length + 1)) / 2;
        for (int num : nums) {
            sum -=num;
        }
        return sum;
    }
}

