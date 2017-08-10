package leetcode;

import java.util.*;

/**
 */
public class L2017041504_350_Intersection_of_Two_Arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            Integer count = map.getOrDefault(n1, 0);
            map.put(n1, count + 1);
        }

        ArrayList<Integer> resultArray = new ArrayList<>();
        for (int n2 : nums2) {
            Integer count = map.getOrDefault(n2, 0);
            if (count == 0) {
                continue;
            }
            resultArray.add(n2);
            map.put(n2, count - 1);
        }
        int[] result = new int[resultArray.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultArray.get(i);
        }
        return result;
    }
}

