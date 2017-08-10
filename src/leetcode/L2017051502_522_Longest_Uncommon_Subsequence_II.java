package leetcode;

import java.util.HashMap;

/**
 */
public class L2017051502_522_Longest_Uncommon_Subsequence_II {
    public int findLUSlength(String[] strs) {

        int max = -1;
        out: for (int i = 0; i < strs.length; i++) {
            String current = strs[i];
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubstring(current, strs[j])) {
                    continue out;
                }
            }

            max = Math.max(max, current.length());
        }
        return max;
    }

    private boolean isSubstring(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int s1Index = 0;
        int s2Index = 0;
        while (s1Index < s1.length() && s2Index < s2.length()) {
            if (s1.charAt(s1Index) == s2.charAt(s2Index)) {
                s1Index++;
                s2Index++;
            } else{
                s2Index++;
            }
        }
        return s1Index == s1.length();
    }
}





