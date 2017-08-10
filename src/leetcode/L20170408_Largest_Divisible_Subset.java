package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-divisible-subset/#/description
 */
public class L20170408_Largest_Divisible_Subset {
    public static void main(String[] args) {
        List<Integer> integers = new L20170408_Largest_Divisible_Subset().largestDivisibleSubset(new int[]{1, 2});
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length < 1) {
            return new ArrayList<>();
        }

        int length = nums.length;
        int[] count = new int[length];
        int[] previous = new int[length];

        count[0] = 1;
        previous[0] = -1;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            count[i] = 1;
            previous[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && count[j] + 1 > count[i]) {
                    count[i] = count[j] + 1;
                    previous[i] = j;
                }
            }
        }

        int maxIndex = 0;
        int maxNum = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxNum) {
                maxNum = count[i];
                maxIndex = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = maxIndex; i != -1; i = previous[i]) {
            result.add(nums[i]);
        }


        return result;
    }
}

