package leetcode;

/**
 */
public class L2017082201_91_Decode_Ways {
    public int numDecodings(String s) {
        if (s == null || s.trim().length() == 0||s.charAt(0)=='0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i + 1] = dp[i];
            }
            boolean canCombine = canCombineWithPrevious(s, i);
            if (canCombine) {
                dp[i + 1] += dp[i - 1];
            }
            if (dp[i + 1] == 0) {
                return 0;
            }
        }
        return dp[s.length()];
    }

    private boolean canCombineWithPrevious(String s, int i) {
        char previousChar = s.charAt(i - 1);
        char currentChar = s.charAt(i);
        return previousChar == '1' || (previousChar == '2' && currentChar <= '6');
    }
}

