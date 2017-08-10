package leetcode;

/**
 */
public class L2017072401_59_Spiral_Matrix_II {
    public static void main(String[] args) {
        System.out.println(String.format("ShippingPossibilities from SCEResponse FC %s EAD %s PickupDate %s", "a", "b"));    }
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        recursive(nums, 0, k);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            stringBuffer.append(nums[i]);
        }
        return stringBuffer.toString();
    }

    private void recursive(int[] nums, int currentPosition, int k) {
        if (k == 1) {
            return;
        }
        int length = nums.length;
        int all = 1;
        for (int i = 1; i < length - currentPosition; i++) {
            all *= i;
        }

        int indexToSwitch = currentPosition + (k - 1) / all;
        switchNums(nums, currentPosition, indexToSwitch);
        recursive(nums, currentPosition + 1, (k - 1) % all + 1);
    }

    private void switchNums(int[] nums, int currentPosition, int indexToSwitch) {
        int temp = nums[indexToSwitch];
        for (int i = indexToSwitch; i > currentPosition; i--) {
            nums[i] = nums[i - 1];
        }
        nums[currentPosition] = temp;
    }
}

