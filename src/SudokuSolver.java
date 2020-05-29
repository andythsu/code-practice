/**
 * @Author asu
 * @Date 5/29/2020
 * @Description solves sudoku using backtracking
 **/
public class SudokuSolver {
    private int[][] board;
    private boolean isSolved;

    public SudokuSolver(int[][] board) {
        this.board = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    public boolean solve() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == 0) {
                    for (int i = 1; i <= 9; i++) {
                        if (testRow(r, i, board) && testCol(c, i, board) && testSquare(r, c, i, board)) {
                            board[r][c] = i;
                            if (solve()) {
                                return true;
                            } else {
                                board[r][c] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        isSolved = true;
        return true;
    }

    private boolean testSquare(int r, int c, int value, int[][] board) {
        int row = r - r % 3;
        int col = c - c % 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == value) return false;
            }
        }
        return true;
    }

    private boolean testCol(int c, int value, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] == value) return false;
        }
        return true;
    }

    private boolean testRow(int r, int value, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[r][i] == value) return false;
        }
        return true;
    }

    public int[][] getSolvedBoard() {
        return board;
    }

    public boolean getIsSolved() {
        return isSolved;
    }
}
