package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 */
public class L20171019_103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> result = new ArrayList<>();

        List<TreeNode> currentLevel = Arrays.asList(root);
        boolean isLeftToRight = true;

        while (currentLevel.size() > 0) {
            ArrayList<Integer> levelValues = new ArrayList<>();
            ArrayList<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode treeNode : currentLevel) {
                levelValues.add(treeNode.val);
                if (treeNode.left != null) {
                    nextLevel.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLevel.add(treeNode.right);
                }
            }
            if (!isLeftToRight) {
                Collections.reverse(levelValues);
            }
            result.add(levelValues);
            currentLevel = nextLevel;
            isLeftToRight = !isLeftToRight;
        }
        return result;

    }
}

