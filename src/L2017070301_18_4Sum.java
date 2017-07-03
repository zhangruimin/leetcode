import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 */
public class L2017070301_18_4Sum {
    public static void main(String[] args) {
        new L2017070301_18_4Sum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                int firstTwoSum = nums[i] + nums[j];
                int lastTwoSum = target - firstTwoSum;
                int k = j + 1;
                int l = length - 1;
                while (k < l) {
                    int s = nums[k] + nums[l];
                    if (s == lastTwoSum) {
                        List<Integer> entry = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        result.add(entry);
                        k++;
                    } else if (s < lastTwoSum) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return removeDuplicate(result);
    }

    private List<List<Integer>> removeDuplicate(ArrayList<List<Integer>> result) {
        HashSet<List<Integer>> set = new HashSet<>();
        set.addAll(result);
        return new ArrayList<>(set);
    }


}

