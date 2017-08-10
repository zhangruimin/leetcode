package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class L2017050601_526_Beautiful_Arrangement {
    private int count = 0;
    private List<Integer> current = new ArrayList<>();

    public int countArrangement(int N) {
        recursive(N);
        return count;
    }

    private void recursive(int n) {
        if (current.size() == n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (current.contains(i)) {
                continue;
            }
            int index = current.size() + 1;

            if (index % i != 0 && i % index != 0) {
                continue;
            }
            current.add(i);
            recursive(n);
            current.remove((Integer)i);
        }
    }
}





