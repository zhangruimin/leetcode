package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 */
public class L2018042802_823_Binary_Trees_With_Factors {
    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1000000000 + 7;
        Arrays.sort(A);

        HashMap<Integer, Long> dp = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            dp.put(A[i], 1L);
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j] == 0) {
                    int d = A[i] / A[j];
                    if (dp.containsKey(d)) {
                        Long count = dp.get(A[i]);
                        count = (count + dp.get(d) * dp.get(A[j]) % MOD) % MOD;
                        dp.put(A[i], count);
                    }
                }
            }
        }

        int result = 0;
        for (Long l : dp.values()) {
            result = (int) ((result + l) % MOD);
        }

        return result;

    }
}
