import java.util.Arrays;

/**
 */
public class L2017062201_151_Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        s = trim(s);
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int start = 0;
        while (start < s.length()) {
            if (chars[start] == ' ') {
                start++;
                continue;
            }
            int end = findEnd(chars, start);
            reverse(chars, start, end);
            start = end + 1;
        }
        return new String(chars);
    }

    private String trim(String s) {
        String trim = s.trim();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < trim.length(); i++) {
            if (i != 0 && trim.charAt(i) == ' ' && trim.charAt(i - 1) == ' ') {
                continue;
            }
            sb.append(trim.charAt(i));
        }
        return sb.toString();
    }

    private int findEnd(char[] chars, int start) {
        for (int i = start + 1; i < chars.length; i++) {
            if (chars[i] == ' ') {
                return i - 1;
            }
        }
        return chars.length - 1;
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;
            start++;
            end--;
        }
    }

}

