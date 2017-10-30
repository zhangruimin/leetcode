package leetcode;

import java.util.HashMap;

/**
 */
public class L20171030_166_Fraction_to_Recurring_Decimal {
    public static void main(String[] args) {
        System.out.println(new L20171030_166_Fraction_to_Recurring_Decimal().fractionToDecimal(-2147483648, 1));

    }

    public String fractionToDecimal(int numerator, int denominator) {
        long lnumerator = numerator;
        long ldenominator = denominator;
        boolean needMinus = false;
        if (lnumerator < 0) {
            lnumerator = -lnumerator;
            needMinus = !needMinus;
        }
        if (ldenominator < 0) {
            ldenominator = -ldenominator;
            needMinus = !needMinus;
        }
        HashMap<Long, Integer> remainAndIndex = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        long m = lnumerator % ldenominator;
        long n = lnumerator / ldenominator;
        if (m == 0) {
            if (needMinus) {
                n=-n;
            }
            return String.valueOf(n);
        }

        sb.append(n).append(".");

        int index = sb.length();
        while (m != 0 && !remainAndIndex.containsKey(m)) {
            remainAndIndex.put(m, index++);
            long current = m * 10;
            n = current / ldenominator;
            m = current % ldenominator;
            sb.append(n);
        }

        if (m != 0) {
            sb.append(")");
            sb.insert(remainAndIndex.get(m), "(");
        }

        if (needMinus) {
            sb.insert(0, "-");
        }

        return sb.toString();
    }
}

