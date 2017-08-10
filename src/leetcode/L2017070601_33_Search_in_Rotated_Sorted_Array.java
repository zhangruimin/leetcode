package leetcode;

/**
 */
public class L2017070601_33_Search_in_Rotated_Sorted_Array {

    public static void main(String[] args) {
        new L2017070601_33_Search_in_Rotated_Sorted_Array().search(new int[]{1, 3, 5}, 1);
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] < target) {
                if (nums[right] < target) {
                    if (nums[mid] < nums[right]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                if (nums[left] <= target) {
                    right = mid - 1;
                } else {
                    if (nums[left] > nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }

                }
            }
        }
        return -1;
    }
}

