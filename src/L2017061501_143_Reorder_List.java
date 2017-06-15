/**
 */
public class L2017061501_143_Reorder_List {
    public void reorderList(ListNode head) {
        int size = getSize(head);
        if (size <= 2) {
            return;
        }
        ListNode secondHalf = reverse(removeSecondHalfFromList(head, (size + 1) / 2));

        merge(head, secondHalf);
    }

    private void merge(ListNode head, ListNode secondHalf) {
        ListNode c1 = head;
        ListNode c2 = secondHalf;

        while (c2 != null) {
            ListNode t2 = c2;
            c2 = c2.next;
            t2.next = c1.next;
            c1.next = t2;
            c1 = t2.next;
        }
    }

    private ListNode reverse(ListNode secondHalf) {
        ListNode previous = secondHalf;
        ListNode current = previous.next;
        previous.next = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;

    }

    private ListNode removeSecondHalfFromList(ListNode head, int lengthToKeep) {
        ListNode current = head;
        for (int i = 0; i < lengthToKeep - 1; i++) {
            current = current.next;
        }
        ListNode secondHalf = current.next;
        current.next = null;
        return secondHalf;
    }

    private int getSize(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}

