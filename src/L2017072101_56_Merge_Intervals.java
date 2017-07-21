import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 */
public class L2017072101_56_Merge_Intervals {
    public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }

        Collections.sort(intervals, Comparator.comparing(i -> i.start));


        Interval first = intervals.get(0);

        int start =first.start;
        int end = first.end;

        for (Interval interval : intervals) {
            if (interval.start > end) {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }else{
                end = Math.max(end, interval.end);
            }
        }

        result.add(new Interval(start, end));
        return result;

    }
}

