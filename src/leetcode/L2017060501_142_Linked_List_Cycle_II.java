package leetcode;

import java.util.HashSet;

/**
 */
public class L2017060501_142_Linked_List_Cycle_II {
    public ListNode detectCycle_mine(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (listNodes.contains(current)) {
                return current;
            }
            listNodes.add(current);
            current = current.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}