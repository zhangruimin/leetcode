package leetcode;

/**
 */
public class L2017041902_344_Reverse_String {

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[length - 1 - i];
            chars[length - 1 - i] = temp;
        }
        return new String(chars);
    }

    public String reverseString_mine(String s) {
        return new StringBuffer(s).reverse().toString();
    }
}


