package leetcode;

import java.util.Stack;

/**
 */
public class L2017041701_331_Verify_Preorder_Serialization_of_a_Binary_Tree {
    public static void main(String[] args) {
        boolean validSerialization = new L2017041701_331_Verify_Preorder_Serialization_of_a_Binary_Tree().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
        System.out.println(validSerialization);
    }

    public boolean isValidSerialization(String preorder) {
        String[] splits = preorder.split(",");

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < splits.length; i++) {
            String current = splits[i];
            if (current.equals("#")) {
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }
            stack.push(current);
        }
        return stack.size()==1 && stack.peek().equals("#");
    }

    public boolean isValidSerialization_mine(String preorder) {
        String[] splits = preorder.split(",");
        if (splits[0].equals("#")) {
            return splits.length == 1;
        }
        Stack<Boolean> inRightStack = new Stack<>();
        inRightStack.push(false);

        for (int i = 1; i < splits.length; i++) {
            if (inRightStack.isEmpty()) {
                return false;
            }
            if (splits[i].equals("#")) {
                Boolean inRight = inRightStack.pop();
                if (!inRight) {
                    inRightStack.add(true);
                } else {
                    while (!inRightStack.isEmpty() && inRightStack.peek()) {
                        inRightStack.pop();
                    }
                    if (inRightStack.isEmpty()) {
                        return i == splits.length - 1;
                    }
                    inRightStack.pop();
                    inRightStack.push(true);
                }
                continue;
            } else {
                inRightStack.push(false);
            }
        }
        return inRightStack.isEmpty();
    }
}


