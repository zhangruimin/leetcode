import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/#/description
 */
public class L20170411_Find_Minimum_in_Rotated_Sorted_Array {


    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
                continue;
            }
            if (nums[mid] > nums[right]) {
                left = mid;
                continue;
            }

            if (mid > 0) {
                return Math.min(nums[mid], nums[mid-1]);
            }
            return nums[mid];
        }
        return nums[left];
    }
}

