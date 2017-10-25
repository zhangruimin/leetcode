package leetcode;

/**
 */
public class L20171023_109_Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != tail && fast.next.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);

        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);
        return root;
    }
}

