import java.util.Arrays;
import java.util.Stack;

/**
 */
public class L2017051001_503_Next_Greater_Element_II {
    public int[] nextGreaterElements(int[] nums) {

        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % length]) {
                result[stack.pop()] = nums[i % length];
            }
            stack.push(i % length);
        }
        return result;
    }
}





