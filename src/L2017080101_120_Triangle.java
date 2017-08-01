import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 */
public class L2017080101_120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        ArrayList<Integer> dp = new ArrayList<>();

        boolean first = true;
        for (List<Integer> row : triangle) {
            if (first) {
                first = false;
                dp.add(row.get(0));
                continue;
            }
            int previousLaySize = dp.size();
            dp.add(dp.get(previousLaySize - 1) + row.get(previousLaySize));
            for (int i = previousLaySize - 1; i > 0; i--) {
                dp.set(i, Math.min(dp.get(i), dp.get(i - 1)) + row.get(i));
            }
            dp.set(0, dp.get(0) + row.get(0));
        }
        return Collections.min(dp);
    }
}

