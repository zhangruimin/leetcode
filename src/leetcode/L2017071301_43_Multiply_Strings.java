package leetcode;

/**
 */
public class L2017071301_43_Multiply_Strings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String sum = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            String partSum = multiply(num1, num2.charAt(i), num2.length() - 1 - i);
            sum = add(sum, partSum);
        }
        return sum;

    }

    private String add(String n1, String n2) {
        if (n1.length() < n2.length()) {
            String temp = n2;
            n2 = n1;
            n1 = temp;
        }

        int lengthDiff = n1.length() - n2.length();
        int previous = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = n2.length() - 1; i >= 0; i--) {
            int sum = getInteger(n2.charAt(i)) + getInteger(n1.charAt(i + lengthDiff)) + previous;
            sb.append(sum % 10);
            previous = sum / 10;
        }

        for (int i = lengthDiff - 1; i >= 0; i--) {
            int integer = getInteger(n1.charAt(i));
            int sum = integer + previous;
            sb.append(sum % 10);
            previous = sum / 10;
        }

        if (previous != 0) {
            sb.append(previous);
        }
        return sb.reverse().toString();
    }

    private String multiply(String num1, char c, int numOfZeros) {
        StringBuffer sb = new StringBuffer();

        int previous = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            char currentChar = num1.charAt(i);
            int i1 = getInteger(currentChar);
            int i2 = getInteger(c);
            int sum = i1 * i2 + previous;
            sb.append(sum % 10);
            previous = sum / 10;
        }
        if (previous != 0) {
            sb.append(previous);
        }
        StringBuffer reverse = sb.reverse();
        for (int i = 0; i < numOfZeros; i++) {
            reverse.append("0");
        }
        return reverse.toString();
    }

    private int getInteger(char c) {
        return c - '0';
    }
}

