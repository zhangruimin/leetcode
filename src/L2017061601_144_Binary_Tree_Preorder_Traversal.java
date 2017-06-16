import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 */
public class L2017061601_144_Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            while (current != null) {
                result.add(current.val);
                if (current.right != null) {
                    stack.push(current.right);
                }
                current = current.left;
            }
        }
        return result;
    }
}

