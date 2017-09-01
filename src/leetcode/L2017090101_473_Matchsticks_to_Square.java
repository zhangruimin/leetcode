package leetcode;

import java.util.Arrays;

/**
 */
public class L2017090101_473_Matchsticks_to_Square {
    public static void main(String[] args) {
        System.out.println(new L2017090101_473_Matchsticks_to_Square().makesquare(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
    }

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }

        int sum = Arrays.stream(nums).sum();

        if (sum % 4 != 0) {
            return false;
        }


        int lineLength = sum / 4;
        int[] edges = new int[4];
        Arrays.fill(edges, lineLength);

        return recursive(0, nums, edges);
    }

    private boolean recursive(int current, int[] nums, int[] edges) {
        if (current == nums.length) {
            for (int edge : edges) {
                if (edge != 0) {
                    return false;
                }
                return true;
            }
        }

        for (int i = 0; i < 4; i++) {
            int remaining = edges[i] - nums[current];
            if (remaining < 0) {
                continue;
            }
            edges[i] = remaining;
            if (recursive(current + 1, nums, edges)) {
                return true;
            }
            edges[i] = remaining + nums[current];
        }
        return false;
    }

}

