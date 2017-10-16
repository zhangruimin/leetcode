package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 */
public class L20171016_94_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        recursiveTraverse(root, result);
        return result;
    }

    private void recursiveTraverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        recursiveTraverse(root.left, result);
        result.add(root.val);
        recursiveTraverse(root.right, result);
    }
}

