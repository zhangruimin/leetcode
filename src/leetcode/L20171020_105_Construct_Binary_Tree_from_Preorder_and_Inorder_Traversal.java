package leetcode;

/**
 */
public class L20171020_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode result = recursive(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return result;

    }

    private TreeNode recursive(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int iIndex = is;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == preorder[ps]) {
                iIndex = i;
                break;
            }
        }
        int leftTreeSize = iIndex - is;
        TreeNode left = recursive(preorder, inorder, ps + 1, ps + leftTreeSize, is, is + leftTreeSize - 1);
        TreeNode right = recursive(preorder, inorder, ps + 1 + leftTreeSize, pe, is + 1 + leftTreeSize, ie);
        root.left = left;
        root.right = right;
        return root;
    }
}

