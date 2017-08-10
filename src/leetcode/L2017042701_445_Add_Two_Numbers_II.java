package leetcode;

import java.util.Stack;

/**
 */
public class L2017042701_445_Add_Two_Numbers_II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        addAll(stack1, l1);
        addAll(stack2, l2);

        ListNode result = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int n1 = getTopNumber(stack1);
            int n2 = getTopNumber(stack2);

            int sum = n1 + n2 + carry;

            ListNode newNode = new ListNode(sum % 10);
            carry = sum/10;
            newNode.next=result;
            result = newNode;
        }

        if (carry == 1) {
            ListNode first = new ListNode(carry);
            first.next=result;
            result = first;
        }

        return result;
    }

    private int getTopNumber(Stack<ListNode> stack1) {
        int n1 = 0;
        if (!stack1.isEmpty()) {
            n1= stack1.pop().val;
        }
        return n1;
    }

    private void addAll(Stack<ListNode> stack, ListNode l) {
        ListNode current = l;
        while (current != null) {
            stack.add(current);
            current = current.next;
        }
    }

    public ListNode addTwoNumbers_mine(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        addAll(stack1, l1);
        addAll(stack2, l2);

        ListNode result = null;
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode n1 = stack1.pop();
            ListNode n2 = stack2.pop();

            int sum = n1.val + n2.val + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum/10;
            newNode.next=result;
            result = newNode;
        }

        while (!stack1.isEmpty()) {
            ListNode n1 = stack1.pop();
            int sum = n1.val + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum/10;
            newNode.next=result;
            result = newNode;
        }


        while (!stack2.isEmpty()) {
            ListNode n2 = stack2.pop();
            int sum = n2.val + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum/10;
            newNode.next=result;
            result = newNode;
        }

        if (carry == 1) {
            ListNode first = new ListNode(carry);
            first.next=result;
            result = first;
        }

        return result;
    }

}





