package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/#/description
 * Interesting. come back
 */
public class L20170409_Find_K_Pairs_with_Smallest_Sums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparing(a -> (a[0] + a[1])));
        ArrayList<int[]> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            heap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k-- > 0 && !heap.isEmpty()) {
            int[] head = heap.poll();

            result.add(new int[]{head[0], head[1]});

            if (head[2] == nums2.length - 1) {
                continue;
            }

            heap.offer(new int[]{head[0], nums2[head[2] + 1], head[2] + 1});
        }
        return result;
    }
}

