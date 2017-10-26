package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class L20171026_116_Populating_Next_Right_Pointers_in_Each_Node {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        List<TreeLinkNode> current = Arrays.asList(root);
        while (current.size() > 0) {
            ArrayList<TreeLinkNode> nextLevel = new ArrayList<>();
            for (int i = 0; i < current.size(); i++) {
                TreeLinkNode node = current.get(i);
                if (i < current.size() - 1) {
                    node.next = current.get(i + 1);
                }
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            current = nextLevel;
        }
    }
}

