import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/#/description
 */
public class L2017041301_Shuffle_an_Array {
    private final int[] nums;
    private final Random random;

    /**
     * Initialize your data structure here.
     */
    public L2017041301_Shuffle_an_Array(int[] nums) {
        this.nums = nums;
        random = new Random();
    }


    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        if(nums == null) {
            return null;
        }
        int[] clone = nums.clone();
        for (int i = 1; i < clone.length; i++) {
            int r = random.nextInt(i + 1);
            int temp = clone[i];
            clone[i] = clone[r];
            clone[r] = temp;
        }
        return clone;
    }
}

