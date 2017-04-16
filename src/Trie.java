import java.util.HashMap;
import java.util.Map;

/**
 */
public class Trie {

    private final Map<Character, Node> nodes;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        nodes = new HashMap<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Map<Character, Node> children = nodes;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Node currentNode = children.getOrDefault(chars[i], new Node(chars[i]));
            if (i == chars.length - 1) {
                currentNode.isLeaf = true;
            }
            children.put(chars[i], currentNode);
            children = currentNode.children;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Map<Character, Node> children = nodes;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!children.containsKey(chars[i])) {
                return false;
            }
            Node node = children.get(chars[i]);
            if (i == chars.length - 1 && node.isLeaf) {
                return true;
            }
            children = node.children;
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Map<Character, Node> children = nodes;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!children.containsKey(chars[i])) {
                return false;
            }
            Node node = children.get(chars[i]);

            children = node.children;
        }
        return true;
    }

}

class Node {
    public Node(char val) {
        this.val = val;
    }
    char val;
    boolean isLeaf;
    Map<Character, Node> children = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return val == node.val;
    }

    @Override
    public int hashCode() {
        return (int) val;
    }
}

