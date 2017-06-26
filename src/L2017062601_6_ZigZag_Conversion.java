/**
 */
public class L2017062601_6_ZigZag_Conversion {
    public String convert(String s, int numRows) {
        StringBuffer[] sbs = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuffer();
        }

        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++) {
                sbs[i].append(s.charAt(index++));
            }

            for (int i = 0; i < numRows - 2 && index < s.length(); i++) {
                sbs[numRows - 2 - i].append(s.charAt(index++));
            }
        }

        StringBuffer sb = new StringBuffer();

        for (StringBuffer stringBuffer : sbs) {
            sb.append(stringBuffer.toString());
        }
        return sb.toString();
    }
}

