/**
 * https://leetcode.com/problems/game-of-life/#/description
 */
public class L20170410_Game_of_Life {
    public static void main(String[] args) {
        L20170410_Game_of_Life life = new L20170410_Game_of_Life();
        int[][] board = {{1}, {1, 0}};
        life.gameOfLife(board);
    }

    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        int length = board.length;
        int width = board[0].length;


        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int neighborsStatus = getNeighborsStatus(board, i, j);
                if (neighborsStatus == 2 && board[i][j] == 1) {
                    board[i][j] = 3;
                    continue;
                }

                if (neighborsStatus == 3) {
                    board[i][j] += 2;
                    continue;
                }

            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = board[i][j]>>1;
            }
        }
    }

    private int getNeighborsStatus(int[][] board, int i, int j) {
        int length = board.length;
        int width = board[0].length;

        int count = 0;

        for (int x = Math.max(0, i - 1); x < Math.min(length, i + 2); x++) {
            for (int y = Math.max(0, j - 1); y < Math.min(width, j + 2); y++) {
                count += board[x][y] & 1;
            }
        }

        count -= board[i][j] & 1;

        return count;
    }
}

