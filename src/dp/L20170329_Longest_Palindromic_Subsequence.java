package dp;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/#/description
 * Created by zrruimin on 3/26/17.
 */
public class L20170329_Longest_Palindromic_Subsequence {
    public static void main(String[] args) {
        new L20170329_Longest_Palindromic_Subsequence().longestPalindromeSubseq("bbbab");
    }

    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }

        int dp[][] = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        for (int span = 1; span < length; span++) {
            for (int left = 0; left + span < length; left++) {
                int right = left + span;
                if (s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = dp[left + 1][right - 1] + 2;
                } else {
                    dp[left][right] = Math.max(dp[left][right - 1], dp[left + 1][right]);
                }
            }
        }
        return dp[0][length - 1];
    }
}

