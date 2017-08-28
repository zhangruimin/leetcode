/**
 */
public class L2017082801_162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        return recursive(0, nums.length - 1, nums);
    }

    private int recursive(int left, int right, int[] nums) {
        if (left == right) {
            return left;
        }

        int mid1 = (left + right) / 2;
        int mid2 = mid1 + 1;
        if (nums[mid1] < nums[mid2]) {
            return recursive(mid2, right, nums);
        }else{
            return recursive(left, mid1, nums);
        }
    }

    public int findPeakElement_iterative(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid1 = (left + right) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]) {
                left = mid2;
            }else{
                right = mid1;
            }
        }
        return left;
    }
    public int findPeakElement_mine(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i - 1;
            }
        }
        return nums.length - 1;

    }
}

