package leetcode;

/**
 */
public class L2018042801_814_Binary_Tree_Pruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        boolean isToBeRemoved = isToBeRemoved(root);
        if (isToBeRemoved) {
            return null;
        }

        return root;
    }

    private boolean isToBeRemoved(TreeNode root) {
        if (root.left != null) {
            boolean left = isToBeRemoved(root.left);
            if (left) {
                root.left = null;
            }
        }

        if (root.right != null) {
            boolean right = isToBeRemoved(root.right);
            if (right) {
                root.right = null;
            }
        }

        return root.left == null && root.right == null && root.val == 0;
    }
}
