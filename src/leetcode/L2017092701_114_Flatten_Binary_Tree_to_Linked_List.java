package leetcode;

/**
 */
public class L2017092701_114_Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        recursive(null, root);
    }

    private TreeNode recursive(TreeNode previous, TreeNode current) {
        if (current == null) {
            return previous;
        }
        if (previous != null) {
            previous.left = null;
            previous.right=current;
        }
        previous=current;
        TreeNode right = current.right;
        TreeNode leftLast = recursive(previous, current.left);
        TreeNode rightLast = recursive(leftLast, right);
        return rightLast;

    }
}

