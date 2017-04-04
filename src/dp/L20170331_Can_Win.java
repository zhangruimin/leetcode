package dp;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/#/description
 * Created by zrruimin on 3/31/17.
 */
public class L20170331_Can_Win {
    public static void main(String[] args) {
        boolean b = new L20170331_Can_Win().canWin(5, 10);
        System.out.println(b);
    }

    public boolean canWin(int maxNum, int target) {
        HashMap<String, Boolean> map = new HashMap<>();
        boolean[] used = new boolean[maxNum + 1];
        return canWinRecursive(maxNum, used, target, map);
    }

    private boolean canWinRecursive(int maxNum, boolean[] used, int target, HashMap<String, Boolean> map) {
        if (map.containsKey(getKey(used))) {
            return map.get(getKey(used));
        }
        for (int i = 1; i <= maxNum; i++) {
            if (!used[i]) {
                if (target - i <= 0) {
                    map.put(getKey(used), true);
                    return true;
                }
                used[i] = true;
                boolean theyWon = canWinRecursive(maxNum, used, target - i, map);
                if (!theyWon) {
                    used[i] = false;
                    map.put(getKey(used), true);
                    return true;
                }
                used[i] = false;
            }
        }

        map.put(getKey(used), false);
        return false;
    }

    private String getKey(boolean[] used) {
        StringBuffer sb = new StringBuffer();
        for (boolean u : used) {
            sb.append(u ? 1 : 0);
        }
        return sb.toString();
    }
}

