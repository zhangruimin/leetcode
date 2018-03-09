package leetcode;

/**
 */
public class L2018030702_647_Palindromic_Substrings {
    public int countSubstrings(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int span = 1; span < length; span++) {
            for (int i = 0; i + span < length; i++) {
                if (s.charAt(i) == s.charAt(i + span) && (span == 1 || dp[i + 1][i + span - 1])) {
                    dp[i][i + span] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
