import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-divisible-subset/#/description
 */
public class L20170408_Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length < 1) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        Object[] lists = new Object[nums.length];

        List<Integer> first = Arrays.asList(nums[0]);
        lists[0] = first;
        for (int i = 1; i < nums.length; i++) {
            List<Integer> current = Arrays.asList(nums[i]);
            lists[i] = current;
            for (int j = 0; j < i; j++) {
                List<Integer> listj = (List<Integer>) lists[j];
                List<Integer> listi = (List<Integer>) lists[i];
                if (nums[i] % nums[j] == 0 && listj.size() + 1 > listi.size()) {
                    listi = new ArrayList<>(listj);
                    listi.add(nums[i]);
                }
            }
        }

        List<Integer> max = first;

        for (Object list : lists) {
            List<Integer> c = (List<Integer>) list;
            if (c.size() > max.size()) {
                max = c;
            }
        }

        return max;
    }
}

