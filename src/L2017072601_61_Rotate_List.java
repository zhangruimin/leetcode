/**
 */
public class L2017072601_61_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int size = getSize(head);

        int numToRotate = k % size;

        int numToKeep = size - numToRotate;

        if (numToKeep == size) {
            return head;
        }

        ListNode current = head;

        for (int i = 0; i < numToKeep - 1; i++) {
            current = current.next;
        }

        ListNode result = current.next;
        current.next = null;

        current = result;
        for (int i = 0; i < numToRotate - 1; i++) {
            current = current.next;
        }

        current.next = head;
        return result;

    }

    private int getSize(ListNode head) {
        int size = 0;

        ListNode current = head;

        while (current != null) {
            size++;
            current = current.next;
        }

        return size;
    }
}

