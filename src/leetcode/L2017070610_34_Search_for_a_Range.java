package leetcode;

/**
 */
public class L2017070610_34_Search_for_a_Range {
    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = binarySearchLeft(nums, target);
        if (left == -1) {
            return new int[]{-1, -1};
        }

        int right = binarySearchRight(nums, target);
        return new int[]{left, right};
    }

    private int binarySearchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right + 1 < nums.length && nums[right + 1] == target) {
            return right + 1;
        }
        return -1;
    }

    private int binarySearchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left - 1 >= 0 && nums[left - 1] == target) {
            return left - 1;
        }
        return -1;
    }


}

