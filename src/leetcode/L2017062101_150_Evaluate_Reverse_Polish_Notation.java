package leetcode;

import java.util.Stack;

/**
 */
public class L2017062101_150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        String operators = "+-*/";
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.valueOf(tokens[0]));
        for (int i = 1; i < tokens.length; i++) {
            if (operators.indexOf(tokens[i]) >= 0) {
                Integer n2 = stack.pop();
                Integer n1 = stack.pop();
                stack.push(calculate(tokens[i], n1, n2));
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    private Integer calculate(String token, Integer n1, Integer n2) {
        if ("+".equals(token)) {
            return n1 + n2;
        } else if ("-".equals(token)) {
            return n1 - n2;
        } else if ("*".equals(token)) {
            return n1 * n2;
        } else {
            return n1 / n2;
        }
    }
}

