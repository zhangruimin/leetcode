package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class L2018041902_816_Ambiguous_Coordinates {
    public static void main(String[] args) {
        System.out.println(new L2018041902_816_Ambiguous_Coordinates().ambiguousCoordinates("(123)"));
        System.out.println(String.valueOf(Double.parseDouble(".00")));

    }

    public List<String> ambiguousCoordinates(String S) {
        String withNoBrackets = S.substring(1, S.length() - 1);
        ArrayList<String> result = new ArrayList<>();

        for (int i = 1; i < withNoBrackets.length(); i++) {
            addCoordinatesWithCommaAtI(result, withNoBrackets, i);
        }
        return result;
    }

    private void addCoordinatesWithCommaAtI(ArrayList<String> result, String s, int i) {
        String firstPart = s.substring(0, i);
        String secondPart = s.substring(i);

        List<String> fPossibilities = findPossibilities(firstPart);
        List<String> sPossibilities = findPossibilities(secondPart);
        for (String fPossibility : fPossibilities) {
            for (String sPossibility : sPossibilities) {
                result.add("(" + fPossibility + ", " + sPossibility + ")");
            }
        }
    }

    private List<String> findPossibilities(String s) {
        ArrayList<String> result = new ArrayList<>();
        if (isValidNum(s, false)) {
            result.add(s);
        }

        StringBuffer sb = new StringBuffer(s);
        for (int i = 1; i < s.length(); i++) {
            sb.insert(i, '.');
            String toCheck = sb.toString();
            if (isValidNum(toCheck, true)) {
                result.add(toCheck);
            }
            sb.deleteCharAt(i);
        }

        return result;
    }

    private boolean isValidNum(String toCheck, boolean withPoint) {
        if (withPoint) {
            if (toCheck.endsWith("0")) {
                return false;
            }


            return !toCheck.startsWith("0") || toCheck.startsWith("0.");
        }
        return toCheck.equals("0") || !toCheck.startsWith("0");
    }
}
