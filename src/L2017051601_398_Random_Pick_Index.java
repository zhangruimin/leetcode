import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 */
public class L2017051601_398_Random_Pick_Index {

    class Solution {

        private final HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        private Random random = new Random();

        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                ArrayList<Integer> orDefault = map.getOrDefault(nums[i], new ArrayList<>());
                orDefault.add(i);
                map.put(nums[i], orDefault);
            }
        }

        public int pick(int target) {
            ArrayList<Integer> all = map.get(target);
            return all.get(random.nextInt(all.size()));
        }
    }
}





