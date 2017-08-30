package leetcode;

import leetcode.TreeNode;

import java.util.ArrayList;

/**
 */
public class L2017082401_230_Kth_Smallest_Element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        index.add(1);

        recursive(root, index, k, result);
        return result.get(0);
    }

    private void recursive(TreeNode node, ArrayList<Integer> index, int k, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }

        recursive(node.left, index, k, result);

        Integer i = index.get(0);
        if (i == k) {
            result.add(node.val);
            return;
        }

        index.set(0, i + 1);
        recursive(node.right, index, k, result);
    }
}

