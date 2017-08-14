package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
    int label;
    public List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
