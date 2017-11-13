package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 */
public class L20171113_227_Basic_Calculator_II {
    public static void main(String[] args) {
        new L20171113_227_Basic_Calculator_II().calculate("1+1");
    }
    public int calculate(String s) {
        List<String> tokens = getTokens(s);
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperands(token)) {
                if (stack.size()>=0&&isHighPriority(stack.peek())) {
                    String op = stack.pop();
                    String left = stack.pop();
                    String result = calc(left, op, token);
                    stack.push(result);
                } else {
                    stack.push(token);
                }
            } else {
                if (isHighPriority(token)) {
                    stack.push(token);
                    continue;
                }
                if (stack.size() > 1) {
                    String right = stack.pop();
                    String op = stack.pop();
                    String left = stack.pop();
                    stack.push(calc(left, op, right));
                }
                stack.push(token);
            }
        }
        if (stack.size() > 1) {
            String right = stack.pop();
            String op = stack.pop();
            String left = stack.pop();
            stack.push(calc(left, op, right));
        }
        return Integer.parseInt(stack.pop());
    }

    private boolean isOperands(String token) {
        return !(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }

    private List<String> getTokens(String s) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                result.add(sb.toString().trim());
                sb.setLength(0);
                result.add(String.valueOf(c));
            } else {
                sb.append(c);
            }
            index++;
        }

        result.add(sb.toString().trim());

        return result;
    }

    private String calc(String left, String op, String right) {
        int l = Integer.parseInt(left);
        int r = Integer.parseInt(right);


        if (op.equals("+")) {
            return String.valueOf(l + r);
        }

        if (op.equals("-")) {
            return String.valueOf(l - r);
        }

        if (op.equals("*")) {
            return String.valueOf(l * r);
        }

        return String.valueOf(l / r);
    }

    private boolean isHighPriority(String token) {
        return token.equals("*") || token.equals("/");
    }
}

