import java.util.Arrays;

/**
 */
public class L2017051701_274_H_Index {
    public int hIndex(int[] citations) {
        int length = citations.length;
        int[] buckets = new int[length + 1];

        for (int citation : citations) {
            if (citation >= length) {
                buckets[length]++;
            } else {
                buckets[citation]++;
            }
        }

        int count = 0;
        for (int i = length; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }

    public int hIndex_mine(int[] citations) {
        Arrays.sort(citations);

        for (int i = 1; i <= citations.length; i++) {
            if (i > citations[citations.length - i]) {
                return i - 1;
            }
        }
        return citations.length;
    }
}





