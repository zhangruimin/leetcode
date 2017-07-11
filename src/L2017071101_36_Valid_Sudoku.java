import java.util.HashSet;

/**
 */
public class L2017071101_36_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> subSquare = new HashSet<>();

            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !column.add(board[j][i])) {
                    return false;
                }

                int rowIndex = i / 3 * 3 + j / 3;
                int columnIndex = i % 3 * 3 + j % 3;

                if (board[rowIndex][columnIndex] != '.' && !subSquare.add(board[rowIndex][columnIndex])) {
                    return false;
                }
            }
        }
        return true;

    }
}

