import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-i/#/description
 */
public class L20170406_Next_Greater_Element_I {
    /**
     * O(n) solution
     * @param findNums
     * @param nums
     * @return
     */
    public int[] nextGreaterElement_ON_Solution(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> toNext = new HashMap<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                toNext.put(stack.pop(), num);
            }
            stack.add(num);
        }
        int[] result = new int[findNums.length];

        for (int i = 0; i < findNums.length; i++) {
            result[i] = toNext.getOrDefault(findNums[i], -1);
        }

        return result;
    }

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        HashMap<Integer, Integer> numToPosition = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToPosition.put(nums[i], i);
        }

        int length = findNums.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int position = numToPosition.get(findNums[i]);
            result[i] = -1;
            for (int j = position + 1; j < nums.length; j++) {
                if (nums[j] > findNums[i]) {
                    result[i] = nums[j];
                    break;
                }
            }
        }

        return result;
    }
}

