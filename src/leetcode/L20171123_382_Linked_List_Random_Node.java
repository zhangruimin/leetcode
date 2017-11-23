package leetcode;

import java.util.Random;

/**
 */
public class L20171123_382_Linked_List_Random_Node {
    class Solution {
        private final ListNode head;
        private int length = 0;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            for (ListNode current = head; current != null; current = current.next) {
                length++;
            }
            this.head = head;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            int r = new Random().nextInt(length);
            ListNode node = findNode(r);
            return node.val;
        }

        private ListNode findNode(int r) {
            ListNode current = this.head;
            while (r > 0) {
                current = current.next;
                r--;
            }
            return current;
        }
    }
}

