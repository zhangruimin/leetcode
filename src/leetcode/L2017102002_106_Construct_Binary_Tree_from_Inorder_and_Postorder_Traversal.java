package leetcode;

/**
 */
public class L2017102002_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode result = recursive(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
        return result;

    }

    private TreeNode recursive(int[] postorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int iIndex = is;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == postorder[pe]) {
                iIndex = i;
                break;
            }
        }
        int leftTreeSize = iIndex - is;
        TreeNode left = recursive(postorder, inorder, ps, ps + leftTreeSize - 1, is, is + leftTreeSize - 1);
        TreeNode right = recursive(postorder, inorder, ps + leftTreeSize, pe - 1, is + 1 + leftTreeSize, ie);
        root.left = left;
        root.right = right;
        return root;
    }
}

