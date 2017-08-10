package leetcode;

import java.util.HashSet;
import java.util.List;

/**
 */
public class L2017061401_139_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak_mine_backtracking(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        return canBreak(s, 0, wordDict);
    }

    private boolean canBreak(String s, int start, List<String> wordDict) {
        if (start >= s.length()) {
            return true;
        }
        for (int i = start; i < s.length(); i++) {
            String first = s.substring(start, i + 1);
            if (wordDict.contains(first) && canBreak(s, i + 1, wordDict)) {
                return true;
            }
        }

        return false;
    }
}

