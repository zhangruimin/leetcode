/**
 */
public class L2017061901_147_Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head.next;

        ListNode result = head;
        result.next = null;

        while (current != null) {
            ListNode toInsert = current;
            current = current.next;
            result = insert(result, toInsert);
        }
        return result;
    }

    private ListNode insert(ListNode result, ListNode toInsert) {
        if (toInsert.val <= result.val) {
            toInsert.next = result;
            return toInsert;
        }

        ListNode previous = result;
        ListNode current = result.next;
        while (current != null && current.val <= toInsert.val) {
            ListNode temp = current;
            current = current.next;
            previous = temp;
        }

        toInsert.next = previous.next;
        previous.next = toInsert;
        return result;
    }
}

