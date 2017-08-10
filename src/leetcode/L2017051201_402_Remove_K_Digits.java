package leetcode;

import java.util.Stack;

/**
 */
public class L2017051201_402_Remove_K_Digits {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }

        if (k == 0) {
            return num;
        }

        Stack<Character> stack = new Stack<>();

        int index = 0;
        int remain = k;
        while (index < num.length()) {
            if (stack.isEmpty() || stack.peek() <= num.charAt(index)) {
                stack.push(num.charAt(index++));
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > num.charAt(index) && remain > 0) {
                stack.pop();
                remain--;
            }
            stack.push(num.charAt(index++));
        }

        while (remain > 0) {
            stack.pop();
            remain--;
        }

        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop());
        }

        stringBuffer.reverse();
        while (stringBuffer.length() > 1 && stringBuffer.charAt(0) == '0') {
            stringBuffer.deleteCharAt(0);
        }

        return stringBuffer.toString();

    }
}





