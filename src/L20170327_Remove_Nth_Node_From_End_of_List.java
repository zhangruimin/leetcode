/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/#/description
 * Created by zrruimin on 3/26/17.
 */
public class L20170327_Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n ; i++){
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;

    }
}

