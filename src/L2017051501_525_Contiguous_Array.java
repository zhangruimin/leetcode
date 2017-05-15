import java.util.HashMap;

/**
 */
public class L2017051501_525_Contiguous_Array {

    public static void main(String[] args) {
        System.out.println(new L2017051501_525_Contiguous_Array().findMaxLength(new int[]{1,1,0,1}));
    }
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int count = 0;
        int max = 0;

        map.put(0, -1);
        while (index < nums.length) {
            if (nums[index] == 1) {
                count++;
            } else {
                count--;
            }
            Integer firstIndex = map.get(count);
            if (firstIndex == null) {
                map.put(count, index);
            } else {
                max = Math.max(max, index - firstIndex);
            }
            index++;
        }
        return max;
    }
}





