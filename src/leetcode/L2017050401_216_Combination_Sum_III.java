package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class L2017050401_216_Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        recursiveCombinationSum3(result, current, 1, k, n);
        return result;
    }

    private void recursiveCombinationSum3(ArrayList<List<Integer>> result, ArrayList<Integer> current, int start, int k, int n) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= 9; i++) {
            current.add(i);
            recursiveCombinationSum3(result, current, i + 1, k - 1, n - i);
            current.remove((Integer)i);
        }
    }
}





