package leetcode;

/**
 */
public class L20171011_79_Word_Search {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canMatch(board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canMatch(char[][] board, int i, int j, String word) {
        int m = board.length;
        int n = board[0].length;
        if (word.length() > m * n) {
            return false;
        }

        boolean[][] visited = new boolean[m][n];

        return recursive(board, i, j, 0, visited, word);
    }

    private boolean recursive(char[][] board, int i, int j, int index, boolean[][] visited, String word) {
        if (index == word.length()) {
            return true;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        if (index + 1 == word.length()) {
            return true;
        }

        visited[i][j] = true;
        if (i > 0 && !visited[i - 1][j]) {
            if (recursive(board, i - 1, j, index + 1, visited, word)) {
                return true;
            }
        }

        if (j > 0 && !visited[i][j - 1]) {
            if (recursive(board, i, j - 1, index + 1, visited, word)) {
                return true;
            }
        }

        if (i < board.length - 1 && !visited[i + 1][j]) {
            if (recursive(board, i + 1, j, index + 1, visited, word)) {
                return true;
            }
        }

        if (j < board[0].length - 1 && !visited[i][j + 1]) {
            if (recursive(board, i, j + 1, index + 1, visited, word)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}

