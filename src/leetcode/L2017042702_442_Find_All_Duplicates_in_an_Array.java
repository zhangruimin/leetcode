package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 */
public class L2017042702_442_Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                result.add(num);
                continue;
            }
            nums[Math.abs(num) - 1] = -nums[Math.abs(num) - 1];
        }

        return result;
    }

    public List<Integer> findDuplicates_mind(int[] nums) {
        boolean[] found = new boolean[nums.length + 1];
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (found[num]) {
                result.add(num);
            }
            found[num] = true;
        }

        return result;
    }

}





