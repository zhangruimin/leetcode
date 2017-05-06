import java.util.Arrays;
import java.util.List;

/**
 */
public class L2017050603_538_Convert_BST_to_Greater_Tree {
    public TreeNode convertBST(TreeNode root) {
        recursive(root, 0);
        return root;

    }

    private int recursive(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        int rightSum = recursive(root.right, sum);
        sum =rightSum+root.val;
        root.val=sum;
        return recursive(root.left, sum);
    }
}





