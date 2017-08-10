package leetcode;

/**
 * https://leetcode.com/problems/base-7/#/description
 */
public class L20170404_Base_7 {

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        }

        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            sb.insert(0, num % 7);
            num = num/7;
        }

        if (negative) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
}

