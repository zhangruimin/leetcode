package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class L20171103_211_Add_and_Search_Word_Data_structure_design {
    class WordDictionary {

        private final Node root;

        private class Node {
            boolean isLeaf = false;
            char val;
            Map<Character, Node> children = new HashMap<>();

            public Node(char val) {
                this.val = val;
            }

            public Node getChild(char aChar) {
                return children.get(aChar);
            }

            public Node addChild(char aChar) {
                Node child = new Node(aChar);
                children.put(aChar, child);
                return child;
            }

            public Map<Character, Node> getChildren() {
                return children;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node('a');
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            char[] chars = word.toCharArray();
            Node current = root;
            for (char aChar : chars) {
                Node child = current.getChild(aChar);
                if (child == null) {
                    child = current.addChild(aChar);
                }
                current = child;
            }
            current.isLeaf = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return recursiveSearch(word, root);
        }

        private boolean recursiveSearch(String word, Node current) {
            if (word.length() == 0) {
                return current.isLeaf;
            }
            char firstChar = word.charAt(0);
            Map<Character, Node> childrenToSearch = new HashMap<>();

            if ('.' == firstChar) {
                childrenToSearch = current.getChildren();
            } else {
                Node child = current.getChild(firstChar);
                if (child != null) {
                    childrenToSearch.put(firstChar, child);
                }
            }


            if (childrenToSearch.size() == 0) {
                return false;
            }

            for (Node node : childrenToSearch.values()) {
                if (recursiveSearch(word.substring(1), node)) {
                    return true;
                }
            }
            return false;
        }
    }
}

