/**
 * https://leetcode.com/problems/is-subsequence/#/description
 */
public class L20170405_Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int lLength = t.length();
        int i = 0;
        int j = 0;

        while (i < s.length() && j < lLength) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }

        }
        return i == sLength;
    }
}

