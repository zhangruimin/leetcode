import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 */
public class L2017081501_310_Minimum_Height_Trees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        if (n == 1) {
            result.add(0);
            return result;
        }
        Map<Integer, Set<Integer>> adjscent = findAdjscent(edges);

        ArrayList<Integer> leaves = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : adjscent.entrySet()) {
            Set<Integer> value = entry.getValue();
            if (value.size() == 1) {
                leaves.add(entry.getKey());
            }
        }

        while (n > 2) {
            n -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();
            for (Integer leaf : leaves) {
                Set<Integer> nodes = adjscent.get(leaf);
                Integer parent = nodes.iterator().next();
                Set<Integer> children = adjscent.get(parent);
                children.remove(leaf);
                if (children.size() == 1) {
                    newLeaves.add(parent);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public List<Integer> findMinHeightTrees_mine(int n, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        Map<Integer, Set<Integer>> adjscent = findAdjscent(edges);
        int minHeight = getHeight(0, adjscent);
        result.add(0);
        for (int i = 1; i < n; i++) {
            int h = getHeight(i, adjscent);
            if (h < minHeight) {
                minHeight = h;
                result.clear();
                result.add(i);
            } else if (h == minHeight) {
                result.add(i);
            }
        }
        return result;
    }

    private Map<Integer, Set<Integer>> findAdjscent(int[][] edges) {
        HashMap<Integer, Set<Integer>> result = new HashMap<>();

        for (int[] edge : edges) {
            Set<Integer> integers = result.computeIfAbsent(edge[0], k -> new HashSet<>());
            integers.add(edge[1]);
            Set<Integer> integers2 = result.computeIfAbsent(edge[1], k -> new HashSet<>());
            integers2.add(edge[0]);
        }
        return result;
    }

    private int getHeight(int root, Map<Integer, Set<Integer>> graph) {
        return recursive(root, -1, graph);
    }

    private int recursive(int node, int parentNode, Map<Integer, Set<Integer>> graph) {
        HashSet<Integer> children = new HashSet<>(graph.getOrDefault(node, new HashSet<>()));
        children.remove(parentNode);

        int max = 0;
        for (Integer child : children) {
            max = Math.max(max, recursive(child, node, graph));
        }
        return max + 1;
    }
}

