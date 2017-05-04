/**
 */
public class L2017050301_55_Jump_Game {

    public boolean canJump(int[] nums) {
        int last = nums.length - 1;

        for (int i = last - 1; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last == 0;
    }

    /**
     * Jump exactly to the last index. Can jump backwards.
     *
     * @param nums
     * @return
     */
    public boolean canJump_mine(int[] nums) {
        int[] status = new int[nums.length];
        status[0] = 2;
        return recursiveJump(nums, status, nums[0]);
    }

    private boolean recursiveJump(int[] nums, int[] status, int index) {
        if (index == nums.length - 1) {
            return true;
        }

        if (index >= nums.length || index < 0 || status[index] == 2 || nums[index] == 0) {
            return false;
        }

        if (status[index] == 0) {
            status[index] = 1;
            if (recursiveJump(nums, status, index + nums[index])) {
                return true;
            }
            status[index] = 2;
            if (recursiveJump(nums, status, index - nums[index])) {
                return true;
            }
            status[index] = 0;
        }
        return false;
    }

}





