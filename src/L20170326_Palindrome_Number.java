/**
 * https://leetcode.com/problems/palindrome-number/#/description
 * No need to consider overflow
 * Created by zrruimin on 3/26/17.
 */
public class L20170326_Palindrome_Number {
    public boolean isPalindrome(int x) {
        return x >= 0 && reverse(x) == x;
    }

    private int reverse(int x){
        int result = 0;
        while(x != 0){
            int tail = x % 10;
            x = x / 10;
            int next  = result * 10 + tail;
            result = next;
        }
        return result;
    }
}
