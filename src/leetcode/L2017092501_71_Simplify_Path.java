package leetcode;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 */
public class L2017092501_71_Simplify_Path {
    public static void main(String[] args) {
        System.out.println(new L2017092501_71_Simplify_Path().simplifyPath("/home/../../.."));
    }

    public String simplifyPath(String path) {
        String trimmed = path.trim();
        if (trimmed.equals(".") || trimmed.equals("/")) {
            return "/";
        }
        String[] split = trimmed.split("/");

        Stack<String> stack = new Stack<>();
        for (String s : split) {
            if (s.equals(".") || s.length() == 0) {
                continue;
            }

            if (s.equals("..")) {
                if (stack.size() > 0) {
                    stack.pop();
                }
                continue;
            }

            stack.push(s);
        }

        String result = stack.stream().collect(Collectors.joining("/"));

        return "/" + result;
    }
}

