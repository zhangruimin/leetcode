/**
 */
public class L2017042501_328_Odd_Even_Linked_List {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;

        ListNode current = evenTail.next;
        boolean isOdd = true;

        while (current != null) {
            if (isOdd) {
                oddTail.next = current;
                oddTail = current;
            } else{
                evenTail.next = current;
                evenTail =current;
            }
            current = current.next;
            isOdd = !isOdd;
        }

        evenTail.next = null;
        oddTail.next = evenHead;
        return head;

    }
}


