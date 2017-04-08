/**
 * https://leetcode.com/problems/license-key-formatting/#/description
 */
public class L20170407_License_Key_Formatting {
    public String licenseKeyFormatting_simpler(String S, int K) {
        char[] chars = S.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != '-') {
                if (sb.length() % (K + 1) == K) {
                    sb.append('-');
                }
                sb.append(chars[i]);
            }
        }
        return sb.reverse().toString().toUpperCase();
    }

    public String licenseKeyFormatting(String S, int K) {
        String upperCase = removeDash(S).toUpperCase();
        int length = upperCase.length();

        if (length <= K) {
            return upperCase;
        }

        StringBuffer sb = new StringBuffer();

        char[] chars = upperCase.toCharArray();
        int head = length % K;
        if (head > 0) {
            for (int i = 0; i < head; i++) {
                sb.append(chars[i]);
            }
            sb.append('-');
        }

        for (int i = head; i < length; i++) {
            if ((i - head) % K == 0 && i != head) {
                sb.append('-');
            }
            sb.append(chars[i]);
        }

        return sb.toString();
    }

    private String removeDash(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar != '-') {
                sb.append(aChar);
            }
        }

        return sb.toString();
    }
}

