package leetcode;

/**
 */
public class L20171012_80_Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int i = 2;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i++] = nums[j];
            }
        }

        return i;
    }
}

