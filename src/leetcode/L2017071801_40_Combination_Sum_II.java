package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 */
public class L2017071801_40_Combination_Sum_II {
    public static void main(String[] args) {
        new L2017071801_40_Combination_Sum_II().combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        ArrayList<Integer> current = new ArrayList<>();

        Arrays.sort(candidates);
        recursive(candidates, 0, target, current, result);
        return new ArrayList<>(result);
    }

    private void recursive(int[] candidates, int index, int target, ArrayList<Integer> current, Set<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (index == candidates.length) {
            return;
        }

        if (candidates[index] > target) {
            return;
        }


        current.add(candidates[index]);
        recursive(candidates, index + 1, target - candidates[index], current, result);
        current.remove(current.size() - 1);
        recursive(candidates, index + 1, target, current, result);
    }
}

