import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 */
public class L2017071201_39_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<Integer>();
        recursive(0, candidates, target,combination, result);
        return result;
    }

    private void recursive(int currentIndex, int[] candidates, int target, ArrayList<Integer> combination, ArrayList<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (currentIndex >= candidates.length) {
            return;
        }

        combination.add(candidates[currentIndex]);
        recursive(currentIndex, candidates, target - candidates[currentIndex], combination, result);
        combination.remove(combination.size() - 1);

        recursive(currentIndex + 1, candidates, target, combination, result);
    }
}

