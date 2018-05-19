package leetcode;

/**
 */
public class L2018051902_833_Find_And_Replace_in_String {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        sort(indexes, sources, targets);

        StringBuffer sb = new StringBuffer(S);

        for (int i = 0; i < indexes.length; i++) {
            if (S.substring(indexes[i]).startsWith(sources[i])) {
                sb.replace(indexes[i], indexes[i] + sources[i].length(), targets[i]);
            }
        }
        return sb.toString();
    }

    private void sort(int[] indexes, String[] sources, String[] targets) {
        for (int i = 0; i < indexes.length; i++) {
            for (int j = i + 1; j < indexes.length; j++) {
                if (indexes[i] < indexes[j]) {
                    int temp = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = temp;

                    String temp2 = sources[i];
                    sources[i] = sources[j];
                    sources[j] = temp2;

                    String temp3 = targets[i];
                    targets[i] = targets[j];
                    targets[j] = temp3;
                }
            }
        }
    }
}
