import java.util.HashMap;
import java.util.HashSet;

/**
 */
public class L2017061301_133_Clone_Graph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashSet<UndirectedGraphNode> visited = new HashSet<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> originalToCloneMap = new HashMap<>();
        UndirectedGraphNode clone = DFSCloneNode(node, visited, originalToCloneMap);
        visited.clear();
        DFSCloneEdge(node, visited, originalToCloneMap);
        return clone;
    }

    private void DFSCloneEdge(UndirectedGraphNode node, HashSet<UndirectedGraphNode> visited, HashMap<UndirectedGraphNode, UndirectedGraphNode> originalToCloneMap) {
        visited.add(node);
        UndirectedGraphNode clone = originalToCloneMap.get(node);

        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(originalToCloneMap.get(neighbor));
            if (!visited.contains(neighbor)) {
                DFSCloneEdge(neighbor,visited,originalToCloneMap);
            }
        }
    }

    private UndirectedGraphNode DFSCloneNode(UndirectedGraphNode node, HashSet<UndirectedGraphNode> visited, HashMap<UndirectedGraphNode, UndirectedGraphNode> originalToCloneMap) {
        visited.add(node);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        originalToCloneMap.put(node, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                DFSCloneNode(neighbor, visited, originalToCloneMap);
            }
        }
        return clone;
    }

}

