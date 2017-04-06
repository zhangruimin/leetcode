import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/#/description
 */
public class L20170406_Find_Bottom_Left_Tree_Value {
    public int findBottomLeftValue(TreeNode root) {

        List<TreeNode> nodes = Arrays.asList(root);
        List<TreeNode> nextLevelNodes = findNextLevelNode(nodes);
        while (!nextLevelNodes.isEmpty()) {
            nodes = nextLevelNodes;
            nextLevelNodes = findNextLevelNode(nodes);
        }
        return nodes.get(0).val;
    }

    private List<TreeNode> findNextLevelNode(List<TreeNode> nodes) {
        ArrayList<TreeNode> result = new ArrayList<>();

        for (TreeNode treeNode : nodes) {
            if (treeNode.left != null) {
                result.add(treeNode.left);
            }
            if (treeNode.right != null) {
                result.add(treeNode.right);
            }
        }
        return result;
    }
}


