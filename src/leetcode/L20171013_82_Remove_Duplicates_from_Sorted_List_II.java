package leetcode;

/**
 */
public class L20171013_82_Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode extraHead = new ListNode(0);

        ListNode tail = extraHead;

        ListNode current = head;

        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                int val = current.val;
                while (current != null && current.val == val) {
                    current = current.next;
                }
            }else{
                ListNode temp = current;
                current=current.next;

                temp.next = null;
                tail.next = temp;
                tail=temp;
            }
        }
        return extraHead.next;
    }
}

