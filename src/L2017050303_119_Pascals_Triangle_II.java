import java.util.Arrays;
import java.util.List;

/**
 */
public class L2017050303_119_Pascals_Triangle_II {

    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        result[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            result[i] = 1;
            for (int j = i - 1; j > 0; j--) {
                result[j] = result[j] + result[j - 1];
            }
        }
        return Arrays.asList(result);
    }

    public List<Integer> getRow_mine(int rowIndex) {

        Integer[] previous = {1};
        for (int i = 1; i <= rowIndex; i++) {
            Integer[] row = new Integer[i + 1];
            row[0] = 1;
            row[i] = 1;
            for (int j = 1; j < row.length - 1; j++) {
                row[j] = previous[j - 1] + previous[j];
            }
            previous = row;
        }
        return Arrays.asList(previous);
    }
}





