package leetcode;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 */
public class L2017060701_129_Sum_Root_to_Leaf_Numbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        ArrayList<Integer> path = new ArrayList<Integer>();

        return recursiveSum(root, path);

    }

    private int recursiveSum(TreeNode root, ArrayList<Integer> path) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            sum = getValueFromPath(path);
        } else {
            sum = recursiveSum(root.left, path) + recursiveSum(root.right, path);
        }
        path.remove(path.size() - 1);
        return sum;
    }

    private int getValueFromPath(ArrayList<Integer> path) {
        return Integer.parseInt(path.stream().map(i -> "" + i).collect(Collectors.joining("")));
    }
}