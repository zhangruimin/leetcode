package leetcode;

/**
 */
public class L2017070601_24_Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode first = head;
        ListNode result = null;
        ListNode tail = null;

        while (first != null) {
            if (first.next != null) {
                ListNode second = first.next;
                ListNode temp = second.next;
                second.next = first;
                first.next = null;
                first = temp;
                if (result == null) {
                    result = second;
                } else {
                    tail.next.next = second;
                }
                tail = second;
            } else {
                tail.next.next = first;
                break;
            }
        }

        return result;
    }

}

