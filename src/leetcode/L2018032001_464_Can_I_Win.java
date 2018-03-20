package leetcode;

import java.util.HashMap;

/**
 */
public class L2018032001_464_Can_I_Win {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 > desiredTotal) {
            return false;
        }
        HashMap<String, Boolean> dp = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < maxChoosableInteger; i++) {
            sb.append('0');
        }

        return recursive(sb, dp, desiredTotal);
    }

    private boolean recursive(StringBuffer sb, HashMap<String, Boolean> dp, int desiredTotal) {
        if (dp.containsKey(sb.toString())) {
            return dp.get(sb.toString());
        }

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                if (i + 1 >= desiredTotal) {
                    dp.put(sb.toString(), true);
                    return true;
                } else {
                    sb.setCharAt(i, '1');
                    if (!recursive(sb, dp, desiredTotal - i - 1)) {
                        sb.setCharAt(i, '0');
                        dp.put(sb.toString(), true);
                        return true;
                    } else {
                        sb.setCharAt(i, '0');
                    }
                }
            }
        }
        dp.put(sb.toString(), false);
        return false;
    }
}
