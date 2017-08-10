package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 */
public class L2017050101_452_Minimum_Number_of_Arrows_to_Burst_Balloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparing(p -> p[1]));
        int count = 1;

        int[] previous = points[0];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > previous[1]) {
                count++;
                previous = points[i];
            }
        }
        return count;
    }
}





