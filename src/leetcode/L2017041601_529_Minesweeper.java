package leetcode;

/**
 */
public class L2017041601_529_Minesweeper {
    public static void main(String[] args) {
        L2017041601_529_Minesweeper l2017041601_529_minesweeper = new L2017041601_529_Minesweeper();
        char[][] board = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        char[][] b = l2017041601_529_minesweeper.updateBoard(board, new int[]{3, 0});
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }


        recursiveUpdateBoard(board, i, j);

        return board;
    }

    private void recursiveUpdateBoard(char[][] board, int i, int j) {
        int num = findAdjecentMines(board, i, j);
        if (num > 0) {
            board[i][j] = (char) ('0' + num);
            return;
        }

        board[i][j] = 'B';

        for (int k = Math.max(0, i - 1); k <= Math.min(board.length - 1, i + 1); k++) {
            for (int l = Math.max(0, j - 1); l <= Math.min(board[0].length - 1, j + 1); l++) {
                if (!(k == i && l == j) && board[k][l] == 'E') {
                    recursiveUpdateBoard(board, k, l);
                }
            }
        }
    }

    private int findAdjecentMines(char[][] board, int i, int j) {
        int count = 0;
        for (int k = Math.max(0, i - 1); k <= Math.min(board.length - 1, i + 1); k++) {
            for (int l = Math.max(0, j - 1); l <= Math.min(board[0].length - 1, j + 1); l++) {
                if (!(k == i && l == j) && board[k][l] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }

}

