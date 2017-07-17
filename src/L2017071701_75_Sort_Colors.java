import java.util.Arrays;

/**
 */
public class L2017071701_75_Sort_Colors {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int num : nums) {
            counts[num]++;
        }

        Arrays.fill(nums, 0, counts[0], 0);
        Arrays.fill(nums, counts[0], counts[0]+counts[1], 1);
        Arrays.fill(nums, counts[0]+counts[1], nums.length, 2);
    }
}

