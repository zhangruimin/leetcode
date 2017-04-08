import java.util.ArrayList;
import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/#/description
 */
public class L20170408_Decode_String {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty() && !isSpecial(chars[i])) {
                sb.append(chars[i]);
                continue;
            }

            if (chars[i] == ']') {
                String decoded = decode(stack);
                if (stack.isEmpty()) {
                    sb.append(decoded);
                } else {
                    addToStack(stack, decoded);
                }
                continue;
            }

            stack.add(chars[i]);
        }
        return sb.toString();
    }

    private void addToStack(Stack<Character> stack, String decoded) {
        for (int i = 0; i < decoded.length(); i++) {
            stack.add(decoded.charAt(i));
        }
    }

    private String decode(Stack<Character> stack) {
        StringBuffer sb = new StringBuffer();
        while (!isSpecial(stack.peek())) {
            sb.append(stack.pop());
        }
        stack.pop();

        StringBuffer numSB = new StringBuffer();
        while (!stack.isEmpty() && isNum(stack.peek())) {
            numSB.append(stack.pop());
        }

        int repeat = Integer.parseInt(numSB.reverse().toString());
        String s = sb.toString();
        for (int i = 1; i < repeat; i++) {
            sb.append(s);
        }
        return sb.reverse().toString();
    }

    private boolean isNum(Character aChar) {
        return aChar >= '0' && aChar <= '9';
    }

    private boolean isSpecial(char aChar) {
        return aChar == '[' || aChar == ']' || isNum(aChar);
    }
}

