package leetcode;

/**
 */
public class L2017091401_86_Partition_List {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode firstPartHead = new ListNode(0);
        ListNode secondPartHead = new ListNode(0);

        ListNode firstPartTail = firstPartHead;
        ListNode secondPartTail = secondPartHead;

        ListNode current = head;

        while (current != null) {
            if (current.val < x) {
                firstPartTail.next = current;
                firstPartTail = current;
            } else {
                secondPartTail.next = current;
                secondPartTail = current;
            }
            current = current.next;
        }

        secondPartTail.next = null;
        firstPartTail.next = secondPartHead.next;
        return firstPartHead.next;

    }

}

