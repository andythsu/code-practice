
/**
 * Gameboard of connect 4
 *
 * @author tsu
 * @since 2019-06-25
 */
public class GameBoard {
    String[][] board;
    String winner = "";
    final String EMPTY_STR = "|";

    public GameBoard(int row, int col) {
        board = new String[row][col];
        initBoard();
    }

    private void initBoard() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = EMPTY_STR;
            }
        }
    }

    public boolean canAdd(int column){
        return isCellEmpty(board[0][column]);
    }

    private boolean isCellEmpty(String value) {
        return value.equals(EMPTY_STR);
    }

    public void put(int col, String userType) {
        for (int r = board.length - 1; r >= 0; r--) {
            if (isCellEmpty(board[r][col])) {
                board[r][col] = userType;
                break;
            }
        }
    }

    private void checkWin() {

    }

    public boolean hasWinner() {
        return winner != "";
    }

    public String getWinner() {
        return winner;
    }
}
