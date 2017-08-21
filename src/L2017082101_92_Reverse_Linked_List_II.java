import leetcode.ListNode;

/**
 */
public class L2017082101_92_Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        for (int i = 1; i < m; i++) {
            previous = current;
            current = current.next;
        }

        ListNode tail = reverseNNodes(current, n-m+1);

        if (previous == null) {
            return tail;
        }

        previous.next = tail;
        return head;

    }

    private ListNode reverseNNodes(ListNode head, int n) {
        ListNode empty = new ListNode(0);
        ListNode last = head;
        ListNode current =head;
        for (int i = 0; i < n; i++) {
            ListNode toInsert = current;
            current = current.next;
            toInsert.next=empty.next;
            empty.next=toInsert;
        }
        last.next=current;
        return empty.next;
    }
}

