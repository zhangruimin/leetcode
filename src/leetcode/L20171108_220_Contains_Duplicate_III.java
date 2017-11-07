package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class L20171108_220_Contains_Duplicate_III {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE + 5);
        System.out.println(new L20171108_220_Contains_Duplicate_III().containsNearbyAlmostDuplicate(new int[]{Integer.MIN_VALUE+5, Integer.MIN_VALUE+2, Integer.MIN_VALUE+10},2,5));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate_mine(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (Math.abs((long) nums[j] - (long) nums[i]) <= (long) t) {
                    return true;
                }
            }
        }
        return false;
    }
}

