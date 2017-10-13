package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 */
public class L2017101302_90_Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> set = new ArrayList<>();
        HashSet<List<Integer>> result = new HashSet<>();
        result.add(set);

        for (int num : nums) {
            HashSet<List<Integer>> newResult = new HashSet<>(result);
            for (List<Integer> r : result) {
                r = new ArrayList<>(r);
                r.add(num);
                Collections.sort(r);
                newResult.add(r);
            }
            result = newResult;
        }


        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (List<Integer> treeSet : result) {
            lists.add(new ArrayList<>(treeSet));
        }
        return lists;
    }
}

