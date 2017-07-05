import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 */
public class L2017070501_22_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {

        ArrayList<String> result = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        recursive(0, n, n, sb, result);
        return result;
    }

    private void recursive(int sum, int left, int right, StringBuffer sb, ArrayList<String> result) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }

        if (left > 0) {
            sb.append('(');
            recursive(sum + 1, left - 1, right, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sum > 0) {
            sb.append(')');
            recursive(sum - 1, left, right - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

