package leetcode;

/**
 */
public class L2018052001_838_Push_Dominoes {
    public static void main(String[] args) {
        System.out.println(new L2018052001_838_Push_Dominoes().pushDominoes(".L.R...LR..L.."));
    }

    public String pushDominoes(String dominoes) {
        int[] toLeft = getDistance(dominoes, 'R', 'L');
        int[] toRight = getDistance(new StringBuffer(dominoes).reverse().toString(), 'L', 'R');

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == '.') {
                if (toLeft[i] > toRight[dominoes.length() - i - 1]) {
                    sb.append('L');
                } else if (toLeft[i] < toRight[dominoes.length() - i - 1]) {
                    sb.append('R');
                } else {
                    sb.append('.');
                }

            } else {
                sb.append(dominoes.charAt(i));
            }
        }
        return sb.toString();

    }

    private int[] getDistance(String dominoes, char r, char l) {
        int[] toLeft = new int[dominoes.length()];

        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < dominoes.length(); i++) {
            char c = dominoes.charAt(i);
            if (c == r) {
                distance = 0;
            }

            if (c == '.') {
                if (distance != Integer.MAX_VALUE) {
                    distance++;
                }
            }

            if (c == l) {
                distance = Integer.MAX_VALUE;
            }

            toLeft[i] = distance;

        }
        return toLeft;
    }
}
