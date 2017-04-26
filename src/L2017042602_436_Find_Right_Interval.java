import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 */
public class L2017042602_436_Find_Right_Interval {

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(3, 4), new Interval(2, 3), new Interval(1, 2)};
        int[] rightInterval = new L2017042602_436_Find_Right_Interval().findRightInterval(intervals);
    }

    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        java.util.NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i].start, i);
        }

        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }

    public int[] findRightInterval_mine(Interval[] intervals) {
        int length = intervals.length;
        IntervalWithIndex[] intervalWithIndices = new IntervalWithIndex[length];

        for (int i = 0; i < length; i++) {
            intervalWithIndices[i] = new IntervalWithIndex(intervals[i], i);
        }

        Arrays.sort(intervalWithIndices, Comparator.comparing(i -> i.interval.start));

        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            Interval current = intervals[i];
            if (current.end > intervalWithIndices[length - 1].interval.start) {
                result[i] = -1;
                continue;
            }

            int left = 0;
            int right = length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (intervalWithIndices[mid].interval.start >= current.end) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (intervalWithIndices[left].interval.start < current.end) {
                left++;
            }
            result[i] = intervalWithIndices[left].index;
        }

        return result;

    }
    class IntervalWithIndex {
        Interval interval;
        int index;

        IntervalWithIndex(Interval interval, int index) {
            this.interval = interval;
            this.index = index;
        }
    }

}





