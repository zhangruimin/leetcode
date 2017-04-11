import java.util.*;

/**
 * https://leetcode.com/problems/third-maximum-number/#/description
 */
public class L20170411_Third_Maximum_Number {

    public static void main(String[] args) {
        L20170411_Third_Maximum_Number t = new L20170411_Third_Maximum_Number();
        t.thirdMax(new int[]{-2147483648,1,1});
    }
    public int thirdMax(int[] nums) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashSet<Object> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            queue.offer(nums[i]);
            if (queue.size() > 3) {
                queue.poll();
            }
        }
        if (queue.size() < 3) {
            while (queue.size() > 1) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}

