package leetcode;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/#/description
 */
public class L20170410_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = head;
        while (result !=null && result.val == val) {
            result = result.next;
        }
        if (result == null) {
            return null;
        }

        ListNode resultTail = result;
        ListNode current = result.next;
        while (current != null) {
            if (current.val != val) {
                resultTail.next = current;
                resultTail = current;
            }
            current=current.next;
        }
        resultTail.next = null;

        return result;
    }
}

