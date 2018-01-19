package leetcode;

/**
 */
public class L20171129_623_Add_One_Row_to_Tree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode result = new TreeNode(v);
            result.left = root;
            return result;
        }

        recursive(root, v, d);
        return root;
    }

    private void recursive(TreeNode root, int v, int d) {
        if (d == 2) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode newLeft = new TreeNode(v);
            TreeNode newRight = new TreeNode(v);
            root.left = newLeft;
            newLeft.left = left;
            root.right = newRight;
            newRight.right = right;
            return;
        }
        if (root.left != null) {
            recursive(root.left, v, d - 1);
        }

        if (root.right != null) {
            recursive(root.right, v, d - 1);
        }
    }
}

