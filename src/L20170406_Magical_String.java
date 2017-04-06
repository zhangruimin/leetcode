/**
 * https://leetcode.com/problems/magical-string/#/description
 */
public class L20170406_Magical_String {
    public int magicalString(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 3 ) {
            return 1;
        }


        int[] nums = new int[n];
        int count = 1;
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 2;

        int fast = 3;
        int slow = 2;
        while (fast < n) {
            int val = 3 - nums[fast - 1];
            for (int i = 0; i < nums[slow] && fast < n; i++, fast++) {
                nums[fast] = val;
                if (val == 1) {
                    count++;
                }
            }
            slow++;
        }
        return count;
    }
}

