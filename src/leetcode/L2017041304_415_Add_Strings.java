package leetcode;

/**
 */
public class L2017041304_415_Add_Strings {
    public static void main(String[] args) {
        new L2017041304_415_Add_Strings().addStrings("12432341234546789089576", "789756345345345345456345345");
    }
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        StringBuffer result = new StringBuffer();
        boolean toNext = false;

        for (int i = 1; i <= num2.length(); i++) {
            int sum = (num1.charAt(num1.length() - i) + num2.charAt(num2.length() - i) - '0' - '0');
            if (toNext) {
                sum++;
            }
            result.append(sum % 10);
            toNext = sum >= 10;
        }

        for (int i = num1.length() - num2.length() - 1; i >= 0; i--) {
            int sum = (num1.charAt(i)- '0');
            if (toNext) {
                sum++;
            }
            result.append(sum % 10);
            toNext = sum >= 10;
        }
        if (toNext) {
            result.append(1);
        }
        return result.reverse().toString();
    }

}

