/**
 */
public class L2017062801_12_Integer_to_Roman {
    public String intToRoman(int num) {
        String[] thousand = {"", "M", "MM", "MMM"};
        String[] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] last = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "XI"};

        return thousand[num / 1000] + hundred[num % 1000 / 100] + ten[num % 100 / 10] + last[num % 10];
    }
}

