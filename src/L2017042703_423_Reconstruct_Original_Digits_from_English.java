/**
 */
public class L2017042703_423_Reconstruct_Original_Digits_from_English {
    public String originalDigits(String s) {
        int[] charCounts = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            charCounts[c - 'a']++;
        }

        int[] digitsCount = new int[10];

        while (charCounts['z' - 'a'] > 0) {
            String zero = "zero";
            countNumber(charCounts, digitsCount, zero, 0);
        }

        while (charCounts['u' - 'a'] > 0) {
            String four = "four";
            countNumber(charCounts, digitsCount, four, 4);
        }

        while (charCounts['w' - 'a'] > 0) {
            String two = "two";
            countNumber(charCounts, digitsCount, two, 2);
        }
        while (charCounts['x' - 'a'] > 0) {
            String six = "six";
            countNumber(charCounts, digitsCount, six, 6);
        }

        while (charCounts['g' - 'a'] > 0) {
            String eight = "eight";
            countNumber(charCounts, digitsCount, eight, 8);
        }
        while (charCounts['r' - 'a'] > 0) {
            String three = "three";
            countNumber(charCounts, digitsCount, three, 3);
        }

        while (charCounts['o' - 'a'] > 0) {
            String one = "one";
            countNumber(charCounts, digitsCount, one, 1);
        }

        while (charCounts['s' - 'a'] > 0) {
            String seven = "seven";
            countNumber(charCounts, digitsCount, seven, 7);
        }
        while (charCounts['f' - 'a'] > 0) {
            String five = "five";
            countNumber(charCounts, digitsCount, five, 5);
        }
        while (charCounts['n' - 'a'] > 0) {
            String nine = "nine";
            countNumber(charCounts, digitsCount, nine, 9);
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < digitsCount.length; i++) {
            while (digitsCount[i] > 0) {
                stringBuffer.append(i);
                digitsCount[i]--;
            }
        }
        return stringBuffer.toString();
    }

    private void countNumber(int[] charCounts, int[] digitsCount, String numString, int num) {
        for (int i = 0; i < numString.length(); i++) {
            charCounts[numString.charAt(i) - 'a']--;
        }
        digitsCount[num]++;
    }

}





