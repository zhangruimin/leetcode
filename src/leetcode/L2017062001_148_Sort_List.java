package leetcode;

/**
 */
public class L2017062001_148_Sort_List {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = null;
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        previous.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode result = null;
        ListNode tail = null;

        while (l1 != null && l2 != null) {
            ListNode current = null;
            if (l1.val < l2.val) {
                current = l1;
                l1 = l1.next;
            } else {
                current = l2;
                l2 = l2.next;
            }
            if (result == null) {
                result = current;
                tail = current;
            } else {
                tail.next = current;
                tail = current;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        }

        if (l2 != null) {
            tail.next = l2;
        }

        return result;
    }
}

