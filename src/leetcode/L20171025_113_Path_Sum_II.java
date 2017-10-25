package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class L20171025_113_Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayList<Integer> currentPath = new ArrayList<>();
        recursive(root, sum, result, currentPath);
        return result;
    }

    private void recursive(TreeNode node, int sum, ArrayList<List<Integer>> result, ArrayList<Integer> currentPath) {
        currentPath.add(node.val);
        if (isLeaf(node) && currentPath.stream().mapToInt(Integer::intValue).sum() == sum) {
            result.add(new ArrayList<>(currentPath));
        } else {
            if (node.left != null) {
                recursive(node.left, sum, result, currentPath);
            }
            if (node.right != null) {
                recursive(node.right, sum, result, currentPath);
            }
        }
        currentPath.remove(currentPath.size() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        return node.right == null && node.left == null;
    }
}

