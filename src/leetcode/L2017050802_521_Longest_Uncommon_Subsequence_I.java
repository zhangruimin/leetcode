package leetcode;

/**
 */
public class L2017050802_521_Longest_Uncommon_Subsequence_I {
    public int findLUSlength(String a, String b) {
        if (a.length() != b.length()) {
            return Math.max(a.length(), b.length());
        }

        if (a.equals(b)) {
            return -1;
        }

        return a.length();
    }
}





