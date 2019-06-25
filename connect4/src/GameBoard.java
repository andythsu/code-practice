
/**
 * Gameboard of connect 4
 *
 * @author tsu
 * @since 2019-06-25
 */
public class GameBoard {
    String[][] board;
    String winner = "";

    public GameBoard(int row, int col) {
        board = new String[row][col];
        initBoard();
    }

    private void initBoard() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = "|";
            }
        }
    }

    public void put(int userChoice, String userType) {

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
