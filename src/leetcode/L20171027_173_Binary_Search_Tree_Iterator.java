package leetcode;

import java.util.Stack;

/**
 */
public class L20171027_173_Binary_Search_Tree_Iterator {
    public class BSTIterator {
        private final Stack<TreeNode> stack = new Stack<TreeNode>();

        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        private void pushAll(TreeNode node) {
            TreeNode current = node;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode nextNode = stack.pop();
            pushAll(nextNode.right);
            return nextNode.val;
        }

    }
}

