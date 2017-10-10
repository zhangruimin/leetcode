package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class L20171010_77_Combinations {
    public List<List<Integer>> combine(int n, int k) {

        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        if (k == 0 || k > n) {
            return result;
        }
        recursive(1, n, k, current, result);
        return result;

    }

    private void recursive(int s, int n, int k, ArrayList<Integer> current, ArrayList<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (n - s + 1 < k) {
            return;
        }
        current.add(s);
        recursive(s + 1, n, k - 1, current, result);
        current.remove(current.size() - 1);
        recursive(s + 1, n, k, current, result);
    }
}

