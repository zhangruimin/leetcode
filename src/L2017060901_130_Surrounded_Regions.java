import java.util.function.BiConsumer;

/**
 */
public class L2017060901_130_Surrounded_Regions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        mark(board, (i, j) -> {
                    if (isOnBorder(board, i, j)) {
                        recursiveMark(board, i, j);
                    }
                }
        );

        mark(board, (i, j) -> {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
        );

        mark(board, (i, j) -> {
                    if (board[i][j] == '1') {
                        board[i][j] = 'O';
                    }
                }
        );

    }

    private void mark(char[][] board, BiConsumer<Integer, Integer> consumer) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                consumer.accept(i, j);
            }
        }
    }

    private void recursiveMark(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = '1';
            if (i > 1)
                recursiveMark(board, i - 1, j);
            if (j > 1)
                recursiveMark(board, i, j - 1);
            if (i + 1 < board.length)
                recursiveMark(board, i + 1, j);
            if (j + 1 < board[0].length)
                recursiveMark(board, i, j + 1);
        }
    }

    private boolean isOnBorder(char[][] board, int i, int j) {
        return i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1;
    }
}