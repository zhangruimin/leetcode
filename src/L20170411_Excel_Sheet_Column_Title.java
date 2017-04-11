/**
 * https://leetcode.com/problems/excel-sheet-column-title/#/description
 */
public class L20170411_Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n != 0) {
            n--;
            int last = n % 26;
            sb.append((char) ('A' + last));
            n /=  26;
        }
        return sb.reverse().toString();
    }
}

