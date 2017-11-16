package leetcode;

/**
 */
public class L20171116_222_Count_Complete_Tree_Nodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (rightHeight < leftHeight) {
            return 1 + getFullTreeNodes(rightHeight) + countNodes(root.left);
        }else{
            return 1 + getFullTreeNodes(leftHeight) + countNodes(root.right);
        }
    }

    private int getFullTreeNodes(int height) {
        if (height == 0) {
            return 0;
        }
        return (1 << height) - 1;
    }

    private int getHeight(TreeNode treeNode) {
        int count = 0;
        TreeNode current = treeNode;
        while (current != null) {
            count++;
            current = current.left;
        }
        return count;
    }
}

