import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 */
public class L2017050602_539_Minimum_Time_Difference {
    public int findMinDifference(List<String> timePoints) {
        timePoints.sort(String::compareTo);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            min = Math.min(min, diff(timePoints.get(i), timePoints.get(i - 1), false));
        }
        min = Math.min(min, diff(timePoints.get(0), timePoints.get(timePoints.size() - 1), true));

        return min;
    }

    private int diff(String current, String previous, boolean addDay) {
        int[] c = Arrays.stream(current.split(":")).map(Integer::parseInt).mapToInt(i -> i).toArray();
        int[] p = Arrays.stream(previous.split(":")).map(Integer::parseInt).mapToInt(i -> i).toArray();

        if (addDay) {
            c[0] += 24;
        }

        return (c[0] - p[0]) * 60 + c[1] - p[1];
    }
}





