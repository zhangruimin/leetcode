package leetcode;

/**
 */
public class L2017081601_306_Additive_Number {
    public static void main(String[] args) {
        System.out.println(new L2017081601_306_Additive_Number().isAdditiveNumber("121474836472147483648"));

    }

    public boolean isAdditiveNumber(String num) {
        int firstLen = 1;
        String firstNum = num.substring(0, firstLen);
        int half = num.length() / 2;
        while (firstLen <= half && isInteger(firstNum)) {
            int secondLen = 1;
            String secondNum = num.substring(firstLen, firstLen + secondLen);
            int remainingLen = num.length() - (firstLen + secondLen);
            while (remainingLen >= firstLen && remainingLen >= secondLen && isInteger(secondNum)) {
                boolean isAddictiveNumber = testNumber(firstNum, secondNum, num);
                if (isAddictiveNumber) {
                    return true;
                }
                secondLen++;
                secondNum = num.substring(firstLen, firstLen + secondLen);
                remainingLen = num.length() - (firstLen + secondLen);
            }
            firstLen++;
            firstNum = num.substring(0, firstLen);
        }
        return false;
    }

    private boolean testNumber(String firstNum, String secondNum, String num) {
        if (num.length() <= firstNum.length() + secondNum.length()) {
            return false;
        }
        long n1 = Long.parseLong(firstNum);
        long n2 = Long.parseLong(secondNum);

        long sum = n1 + n2;

        int index = firstNum.length() + secondNum.length();
        while (sum >= Math.max(n1, n2)) {
            String sumString = String.valueOf(sum);
            if (!compareSumToNum(sumString, index, num)) {
                return false;
            }
            if (index + sumString.length() == num.length()) {
                return true;
            }
            n1 = n2;
            n2 = sum;
            sum = n1 + n2;
            index = index + sumString.length();
        }

        return false;
    }

    private boolean compareSumToNum(String sum, int index, String num) {
        return sum.equals(num.substring(index, Math.min(num.length(), index + sum.length())));
    }

    private boolean isInteger(String num) {
        if (num.length() > 1 && num.charAt(0) == '0') {
            return false;
        }
        int maxValue = Integer.MAX_VALUE;
        String max = String.valueOf(maxValue);
        return num.length() < max.length() || num.compareTo(max) <= 0;
    }
}

