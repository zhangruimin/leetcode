import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 */
public class L2017072001_47_Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {

        HashSet<List<Integer>> result = new HashSet<>();

        ArrayList<Integer> current = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        recursive(nums, current, used, result);
        return new ArrayList<>(result);

    }

    private void recursive(int[] nums, ArrayList<Integer> current, boolean[] used, HashSet<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            current.add(nums[i]);
            recursive(nums, current, used, result);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}

