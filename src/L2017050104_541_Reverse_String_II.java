/**
 */
public class L2017050104_541_Reverse_String_II {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i = i + 2 * k) {
            reverseKFromI(chars, k, i);
        }
        return new String(chars);
    }

    private void reverseKFromI(char[] chars, int k, int i) {
        k = Math.min(k, chars.length - i);
        int mid = k / 2;
        for (int j = 0; j < mid; j++) {
            switchChars(chars, i + j, i + k - j - 1);
        }
    }

    private void switchChars(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}





