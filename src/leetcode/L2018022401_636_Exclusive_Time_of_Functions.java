package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 */
public class L2018022401_636_Exclusive_Time_of_Functions {

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> startStack = new Stack<>();
        HashMap<Integer, Integer> timeMap = new HashMap<>();
        int[] previous = null;
        for (String log : logs) {
            int[] split = split(log);
            if (previous != null) {
                if (split[1] == 0) {
                    Integer previousCount = timeMap.getOrDefault(previous[0], 0);
                    if (previous[1] == 0) {
                        previousCount += (split[2] - previous[2]);
                        timeMap.put(previous[0], previousCount);
                    } else if (startStack.size() > 0) {
                        int[] peek = startStack.peek();
                        Integer peekCount = timeMap.getOrDefault(peek[0], 0);
                        peekCount += (split[2] - previous[2] - 1);
                        timeMap.put(peek[0], peekCount);
                    }
                } else {
                    Integer currentCount = timeMap.getOrDefault(split[0], 0);

                    if (previous[1] == 0) {
                        currentCount += (split[2] - previous[2] + 1);
                    } else {
                        currentCount += (split[2] - previous[2]);
                    }
                    timeMap.put(split[0], currentCount);
                    startStack.pop();
                }
            }
            if (split[1] == 0) {
                startStack.push(split);
            }
            previous = split;
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = timeMap.getOrDefault(i, 0);
        }
        return result;
    }

    private int[] split(String log) {
        String[] split = log.split(":");
        int[] result = new int[3];
        result[0] = Integer.parseInt(split[0]);
        result[1] = split[1].equals("start") ? 0 : 1;
        result[2] = Integer.parseInt(split[2]);
        return result;
    }
}
