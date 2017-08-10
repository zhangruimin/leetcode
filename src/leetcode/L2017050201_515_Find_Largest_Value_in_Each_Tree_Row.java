package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class L2017050201_515_Find_Largest_Value_in_Each_Tree_Row {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        ArrayList<TreeNode> current = new ArrayList<>();
        current.add(root);
        while (!current.isEmpty()) {
            ArrayList<TreeNode> children = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for (TreeNode treeNode : current) {
                max = Math.max(max, treeNode.val);
                if (treeNode.left != null) {
                    children.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    children.add(treeNode.right);
                }
            }
            result.add(max);
            current = children;
        }
        return result;
    }
}





