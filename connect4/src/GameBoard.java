
/**
 * Gameboard of connect 4
 *
 * @author tsu
 * @since 2019-06-25
 */
public class GameBoard {
    String[][] board;
    String winner = "";
    int MAX_ROW;
    int MAX_COL;
    final String EMPTY_STR = "|";

    public GameBoard(int row, int MAX_COL) {
        board = new String[row][MAX_COL];
        this.MAX_ROW = row;
        this.MAX_COL = MAX_COL;
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
        return column < MAX_COL && isCellEmpty(board[0][column]);
    }

    private boolean isCellEmpty(String value) {
        return value.equals(EMPTY_STR);
    }

    public void put(int col, String userType) {
        int r;
        for (r = board.length - 1; r >= 0; r--) {
            if (isCellEmpty(board[r][col])) {
                board[r][col] = userType;
                break;
            }
        }
        // check winner
        int horizontalSum = checkWin(r, col, 1, 0, userType) + checkWin(r, col, -1, 0, userType);
        int verticalSum = checkWin(r, col, 0, 1, userType) + checkWin(r, col, 0, -1, userType);
        int leftTopRightBotSum = checkWin(r, col, -1, -1, userType) + checkWin(r, col, 1, 1, userType);
        int rightTopLeftBotSum = checkWin(r, col, 1, -1, userType) + checkWin(r, col, -1, 1, userType);
        if(horizontalSum > 4 || verticalSum > 4 || leftTopRightBotSum > 4 || rightTopLeftBotSum > 4){
            this.winner = userType;
        }
    }

    private int checkWin(int currentX, int currentY, int dirX, int dirY, String userType) {
        int count = 0;
        while(currentX >= 0 && currentX < MAX_COL && currentY >= 0 && currentY < MAX_ROW){
            if(board[currentX][currentY].equals(userType)){
                count++;
            }
            currentX += dirX;
            currentY += dirY;
        }
        return count;
    }

    public boolean hasWinner() {
        return winner != "";
    }

    public String getWinner() {
        return winner;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(" ");
        for(int c = 0; c< MAX_COL; c++){
            sb.append(c);
            sb.append(" ");
        }

        sb.append("\n");

        for(int r=0; r<board.length; r++){
            sb.append(r);
            sb.append(" ");
            for(int c=0; c<board[r].length; c++){
                sb.append(board[r][c]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
