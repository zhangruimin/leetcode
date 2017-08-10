package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/#/description
 * Created by zrruimin on 3/26/17.
 */
public class L20170327_Permutations_Iterative {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> pre = new ArrayList<>();
        pre.add(new ArrayList<>());

        for(int current: nums){
            List<List<Integer>> cur = new ArrayList<>();
            for(List<Integer> preElement: pre){
                for(int i = 0; i <= preElement.size(); i++){
                    List<Integer> newElement = new ArrayList<>(preElement);
                    newElement.add(i, current);
                    cur.add(newElement);
                }
            }
            pre = cur;
        }
        return pre;
    }
}
