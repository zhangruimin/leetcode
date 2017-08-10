package leetcode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/#/description
 */
public class L20170407_Minimum_Absolute_Difference_in_BST {
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<>();
        findValues(root, values);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            min = Math.min(values.get(i) - values.get(i - 1), min);
        }
        return min;
    }

    private void findValues(TreeNode root, ArrayList<Integer> values) {
        if (root == null) {
            return;
        }
        findValues(root.left, values);
        values.add(root.val);
        findValues(root.right,values);
    }
}

