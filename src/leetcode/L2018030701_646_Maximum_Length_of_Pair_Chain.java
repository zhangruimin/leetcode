package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 */
public class L2018030701_646_Maximum_Length_of_Pair_Chain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int previousEnd = pairs[0][1];
        int count=1;
        for (int[] pair : pairs) {
            if (pair[0] > previousEnd) {
                count++;
                previousEnd = pair[1];
            }
        }
        return count;
    }
}
