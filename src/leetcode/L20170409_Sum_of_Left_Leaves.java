package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/#/description
 */
public class L20170409_Sum_of_Left_Leaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.left != null) {
            TreeNode left = root.left;
            if (left.left == null && left.right == null) {
                sum += left.val;
            } else {
                sum += sumOfLeftLeaves(left);
            }
        }

        sum += sumOfLeftLeaves(root.right);
        return sum;
    }
}

