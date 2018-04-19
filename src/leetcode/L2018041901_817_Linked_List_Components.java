package leetcode;

/**
 */
public class L2018041901_817_Linked_List_Components {
    public int numComponents(ListNode head, int[] G) {
        boolean[] isInG = new boolean[10000];

        for (int i : G) {
            isInG[i]=true;
        }

        int count =0;

        boolean isInLink = false;
        for (ListNode current = head;current!=null;current=current.next) {
            if (isInG[current.val]) {
                if (!isInLink) {
                    isInLink = true;
                    count++;
                }
            }else{
                isInLink = false;
            }
        }

        return count;
    }
}
