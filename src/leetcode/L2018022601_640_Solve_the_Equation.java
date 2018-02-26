package leetcode;

/**
 */
public class L2018022601_640_Solve_the_Equation {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("+2"));
        System.out.println(new L2018022601_640_Solve_the_Equation().solveEquation("-x=1"));
    }

    public String solveEquation(String equation) {
        int isLeft = 1;
        int isPlus = 1;
        StringBuffer token = new StringBuffer();
        int xCount = 0;
        int numberCount = 0;
        for (int i = 0; i <= equation.length(); i++) {
            if (i == equation.length()||isOperator(equation, i) || isEqual(equation, i) ) {
                if (token.length() == 0) {
                    isPlus = isPlus(equation, i);
                    continue;
                }
                if (token.charAt(token.length() - 1) == 'x') {
                    String substring = token.substring(0, token.length() - 1);
                    if (substring.length() == 0) {
                        substring = "1";
                    }
                    xCount += Integer.parseInt(substring) * isLeft * isPlus;
                } else {
                    numberCount += Integer.parseInt(token.toString()) * isLeft * isPlus;
                }

                token.setLength(0);

                if (i == equation.length()) {
                    break;
                }
                if (isOperator(equation, i)) {
                    isPlus = isPlus(equation, i);
                }
                if (isEqual(equation, i)) {
                    isLeft = -1;
                    isPlus = 1;
                }
            } else {
                token.append(equation.charAt(i));
            }
        }
        if (xCount == 0) {
            if (numberCount == 0) {
                return "Infinite solutions";
            }
            return "No solution";
        }

        return "x=" + (-numberCount / xCount);
    }

    private int isPlus(String equation, int i) {
        return equation.charAt(i) == '+' ? 1 : -1;
    }

    private boolean isOperator(String equation, int i) {
        return equation.charAt(i) == '+' || equation.charAt(i) == '-';
    }

    private boolean isEqual(String equation, int i) {
        return equation.charAt(i) == '=';
    }
}
