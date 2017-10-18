package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 */
public class L20171018_95_Unique_Binary_Search_Trees_II {
    private class Pair {
        int i;
        int j;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (i != pair.i) return false;
            return j == pair.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();
            treeNodes.add(null);
            return treeNodes;
        }
        HashMap<Pair, List<TreeNode>> pairToList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            TreeNode treeNode = new TreeNode(i);
            List<TreeNode> treeNodes = Arrays.asList(treeNode);
            pairToList.put(new Pair(i, i), treeNodes);
        }

        return recursive(1, n, pairToList);
    }

    private List<TreeNode> recursive(int i, int j, HashMap<Pair, List<TreeNode>> pairToList) {
        if (i > j) {
            ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();
            treeNodes.add(null);
            return treeNodes;
        }
        List<TreeNode> l = pairToList.get(new Pair(i, j));
        if (l != null) {
            return l;
        }

        ArrayList<TreeNode> current = new ArrayList<>();
        for (int k = i; k <= j; k++) {
            List<TreeNode> left = recursive(i, k - 1, pairToList);
            List<TreeNode> right = recursive(k + 1, j, pairToList);
            for (TreeNode lc : left) {
                for (TreeNode rc : right) {
                    TreeNode root = new TreeNode(k);
                    root.left=lc;
                    root.right=rc;
                    current.add(root);
                }
            }
        }
        pairToList.put(new Pair(i, j), current);
        return current;
    }
}

