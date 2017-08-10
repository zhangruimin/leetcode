package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class L2017041503_241_Different_Ways_to_Add_Parentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Character> operators = new ArrayList<>();
        List<Integer> operands = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                operators.add(input.charAt(i));
                operands.add(Integer.parseInt(sb.toString()));
                sb.delete(0, sb.length());
            } else {
                sb.append(input.charAt(i));
            }
        }
        operands.add(Integer.parseInt(sb.toString()));

        return findWays(operands, operators);
    }

    private List<Integer> findWays(List<Integer> operands, List<Character> operators) {
        if (operands.size() == 1 && operators.size() == 0) {
            return operands;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < operators.size(); i++) {
            List<Integer> left = findWays(operands.subList(0, i + 1), operators.subList(0, i));
            List<Integer> right = findWays(operands.subList(i + 1, operands.size()), operators.subList(i + 1, operators.size()));
            for (Integer l : left) {
                for (Integer r : right) {
                    switch (operators.get(i)) {
                        case '-':
                            result.add(l - r);
                            break;
                        case '+':
                            result.add(l + r);
                            break;
                        case '*':
                            result.add(l * r);
                            break;
                    }
                }
            }
        }
        return result;
    }
}

