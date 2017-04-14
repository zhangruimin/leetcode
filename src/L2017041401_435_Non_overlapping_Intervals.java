import java.util.Arrays;
import java.util.Comparator;

/**
 */
public class L2017041401_435_Non_overlapping_Intervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length < 2) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparing(i -> i.end));

        Interval previous = intervals[0];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= previous.end) {
                count++;
                previous = intervals[i];
            }
        }
        return intervals.length - count;
    }

}

