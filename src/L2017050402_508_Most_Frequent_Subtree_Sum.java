import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 */
public class L2017050402_508_Most_Frequent_Subtree_Sum {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        recursiveFind(countMap, root);
        ArrayList<Integer> result = new ArrayList<>();
        int maxFrequency = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            Integer f = entry.getValue();
            if (f > maxFrequency) {
                maxFrequency = f;
                result.clear();
                result.add(entry.getKey());
            } else if (f == maxFrequency) {
                result.add(entry.getKey());
            }
        }
        int[] a = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            a[i] = result.get(i);
        }
        return a;
    }

    private int recursiveFind(HashMap<Integer, Integer> countMap, TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = recursiveFind(countMap, root.left);
        int r = recursiveFind(countMap, root.right);
        int sum = l + r + root.val;
        countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        return sum;
    }
}





