/**
 * https://leetcode.com/problems/detect-capital/#/description
 */
public class L20170406_Detect_Capital {
    public boolean detectCapitalUse(String word) {

        if (word.length() <= 1) {
            return true;
        }

        for (int i = 1; i < word.length(); i++) {
            if (isCapital(word.charAt(i)) == isCapital(word.charAt(i - 1))) {
                continue;
            }
            if (isCapital(word.charAt(i))) {
                return false;
            } else{
                if (i > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCapital(char c) {
        return c >= 'A' && c <= 'Z';
    }
}

