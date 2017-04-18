import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 */
public class L2017041801_486_Predict_the_Winner {
    public static void main(String[] args) {
        new L2017041801_486_Predict_the_Winner().PredictTheWinner_mine(new int[]{1, 3, 1});
    }
    public boolean PredictTheWinner(int[] nums){
        return getMyPoints(nums, 0, nums.length - 1) >= 0;
    }

    private int getMyPoints(int[] nums, int s, int e) {
        if (s == e) {
            return nums[s];
        }

        return Math.max(nums[s] - getMyPoints(nums, s + 1, e), nums[e] - getMyPoints(nums, s, e - 1));
    }


    public boolean PredictTheWinner_mine(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        Map<String, Integer> dp = new HashMap<>();
        int max = getMax(nums, 0, nums.length - 1, dp);
        return max >= (sum+1) / 2;
    }

    private int getMax(int[] nums, int start, int end, Map<String, Integer> dp) {
        String key = getKey(start, end);
        Integer cachedValue = dp.get(key);
        if (cachedValue != null) {
            return cachedValue;
        }

        if (start == end) {
            return nums[start];
        }

        if (start == end - 1) {
            return Math.max(nums[start], nums[end]);
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }

        int firstChoice = sum - getMax(nums, start + 1, end, dp);
        int secondChoice = sum - getMax(nums, start, end - 1, dp);
        int max = Math.max(firstChoice, secondChoice);
        dp.put(key, max);
        return max;
    }

    private String getKey(int start, int end) {
        return start + "," + end;
    }
}


