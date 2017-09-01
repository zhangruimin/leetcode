package leetcode;

import java.util.Stack;

/**
 */
public class L2017083101_388_Longest_Absolute_File_Path {
    public static void main(String[] args) {
        System.out.println(new L2017083101_388_Longest_Absolute_File_Path().lengthLongestPath("dir\n        file.txt"));
    }
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        Stack<String> path = new Stack<>();

        int maxLength = 0;
        int index = 0;

        while (index < input.length()) {
            NodeInfo node = findNextToken(index, input);
            while (node.depth <= path.size()) {
                path.pop();
            }
            if (node.isFile) {

                int len = 0;
                for (String p : path) {
                    len++;
                    len += p.length();
                }

                len += node.nodeName.length();
                maxLength = Math.max(maxLength, len);
            } else {
                    path.push(node.nodeName);
            }
            index = node.endIndex;
        }
        return maxLength;
    }

    private NodeInfo findNextToken(int index, String input) {
        int depth = 1;
        StringBuffer sb = new StringBuffer();
        if (input.charAt(index) == '\n') {
            index ++;
        }
        while (input.charAt(index) == '\t') {
            index ++;
            depth++;
        }
        boolean isFile = false;
        while (index < input.length() && input.charAt(index) != '\n') {

            sb.append(input.charAt(index));
            if (input.charAt(index) == '.') {
                isFile = true;
            }
            index++;
        }

        return new NodeInfo(sb.toString(), index, depth, isFile);
    }

    private class NodeInfo {
        String nodeName;
        int endIndex;
        int depth;
        boolean isFile;

        private NodeInfo(String nodeName, int endIndex, int depth, boolean isFile) {
            this.nodeName = nodeName;
            this.endIndex = endIndex;
            this.depth = depth;
            this.isFile = isFile;
        }
    }

}

