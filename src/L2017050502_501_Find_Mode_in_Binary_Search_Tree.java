import java.util.ArrayList;
import java.util.List;

/**
 */
public class L2017050502_501_Find_Mode_in_Binary_Search_Tree {
    private int maxCount = 0;
    private List<Integer> maxValues = new ArrayList<>();
    private Integer previous = null;
    private int currentCount = 0;


    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        recursiveFindMode(root);
        return maxValues.stream().mapToInt(i -> i).toArray();
    }

    private void recursiveFindMode(TreeNode root) {
        if (root == null) {
            return;
        }
        recursiveFindMode(root.left);
        if (previous == null || root.val != previous) {
            currentCount = 1;
            previous = root.val;
        } else {
            currentCount++;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            maxValues.clear();
            maxValues.add(root.val);
        } else if (currentCount == maxCount) {
            maxValues.add(root.val);
        }

        recursiveFindMode(root.right);
    }
}





