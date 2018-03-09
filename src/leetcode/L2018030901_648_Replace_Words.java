package leetcode;

import java.util.List;

/**
 */
public class L2018030901_648_Replace_Words {
    class Node {
        char value;
        boolean isLeaf;
        Node[] children = new Node[26];
    }

    public String replaceWords(List<String> dict, String sentence) {
        String[] split = sentence.trim().split(" ");

        Node root = constructTree(dict);
        StringBuffer result = new StringBuffer();
        StringBuffer word = new StringBuffer();
        for (int i = 0; i < sentence.length(); i++) {
            if (!isLetter(sentence.charAt(i))) {
                result.append(replace(root, word));
                result.append(sentence.charAt(i));
                word.setLength(0);
            } else {
                word.append(sentence.charAt(i));
            }
        }
        result.append(replace(root, word));
        return result.toString();
    }

    private Node constructTree(List<String> dict) {
        Node root = new Node();
        for (String word : dict) {
            addToRoot(root, word, 0);
        }
        return root;
    }

    private void addToRoot(Node root, String word, int i) {
        char c = word.charAt(i);
        Node child = root.children[c - 'a'];
        if (child == null) {
            child = new Node();
            child.value = c;
            root.children[c - 'a'] = child;
        }
        if (i == word.length() - 1) {
            child.isLeaf=true;
        }else{
            addToRoot(child, word, i + 1);
        }
    }

    private String replace(Node dict, StringBuffer word) {
        if (word.length() == 0) {
            return "";
        }

        StringBuffer stringBuffer = new StringBuffer();
        Node currentNode = dict;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node child = currentNode.children[c - 'a'];
            if (child == null) {
                return word.toString();
            } else {
                stringBuffer.append(c);
                if (child.isLeaf) {
                    return stringBuffer.toString();
                } else {
                    currentNode = child;
                }
            }
        }
        return word.toString();
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
}
