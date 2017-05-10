/**
 */
public class L2017050801_537_Complex_Number_Multiplication {
    public static void main(String[] args) {
        new L2017050801_537_Complex_Number_Multiplication().complexNumberMultiply("1+1i", "1+1i");
    }
    public String complexNumberMultiply(String a, String b) {
        int[] splitA = splitComplex(a);
        int[] splitB = splitComplex(b);
        int firstPart = splitA[0] * splitB[0] - splitA[1] * splitB[1];
        int secondPart = splitA[0] * splitB[1] + splitA[1] * splitB[0];
        return "" + firstPart + "+" + secondPart + "i";
    }

    private int[] splitComplex(String s) {
        String[] split = s.split("\\+");
        int[] result = new int[2];
        result[0] = Integer.parseInt(split[0]);
        result[1] = Integer.parseInt(split[1].substring(0, split[1].length() - 1));
        return result;
    }
}





