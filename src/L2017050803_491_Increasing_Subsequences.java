import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 */
public class L2017050803_491_Increasing_Subsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int num : nums) {
            ArrayList<List<Integer>> clone = new ArrayList<>(result);
            for (List<Integer> previous : clone) {
                if (num >= previous.get(previous.size() - 1)) {
                    ArrayList<Integer> current = new ArrayList<>(previous);
                    current.add(num);
                    result.add(current);
                }
            }
            result.add(Arrays.asList(num));
        }
        return result.stream().filter(l -> l.size() > 1).collect(Collectors.toList());
    }

    public List<List<Integer>> findSubsequences_mine(int[] nums) {
        ArrayList<List<Integer>> all = new ArrayList<>();
        for (int num : nums) {
            ArrayList<List<Integer>> clone = new ArrayList<>(all);
            for (List<Integer> pre : clone) {
                if (num >= pre.get(pre.size() - 1)) {
                    ArrayList<Integer> current = new ArrayList<>(pre);
                    current.add(num);
                    all.add(current);
                }
            }
            all.add(Arrays.asList(num));
        }

        List<List<Integer>> result = all.stream()
                .filter(a -> a.size() > 1)
                .sorted((o1, o2) -> {
                    if (o1.size() != o2.size()) {
                        return o1.size() - o2.size();
                    }

                    for (int i = 0; i < o1.size(); i++) {
                        if (o1.get(i) != o2.get(i)) {
                            return o1.get(i) - o2.get(i);
                        }
                    }
                    return 0;
                }).collect(Collectors.toList());

        if (result.size() == 0) {
            return result;
        }

        List<Integer> previous = null;
        Iterator<List<Integer>> iterator = result.iterator();

        while (iterator.hasNext()) {
            List<Integer> current = iterator.next();
            if (previous != null && isSame(current, previous)) {
                iterator.remove();
            }
            previous = current;
        }

        return result;
    }

    private boolean isSame(List<Integer> current, List<Integer> previous) {
        if (current.size() != previous.size()) {
            return false;
        }

        for (int i = 0; i < current.size(); i++) {
            if (current.get(i) != previous.get(i)) {
                return false;
            }
        }
        return true;
    }
}





