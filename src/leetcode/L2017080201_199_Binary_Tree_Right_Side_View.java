package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class L2017080201_199_Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        recursive(root, 0, result);
        return result;
    }

    private void recursive(TreeNode root, int level, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(root.val);
        }
        recursive(root.right, level + 1, result);
        recursive(root.left, level + 1, result);
    }
}

