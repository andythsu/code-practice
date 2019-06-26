import java.util.Scanner;

/**
 * Connect 4
 *
 * @author tsu
 * @since 2019-06-25
 */
public class connect4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to connect 4. specify your board size");
        System.out.println("row: ");
        int row = input.nextInt();
        System.out.println("col: ");
        int col = input.nextInt();
        GameBoard gameBoard = new GameBoard(row, col);

        String userType;
        int userContinue = 0;
        int round = 0;

        System.out.println("current board: ");
        System.out.println(gameBoard.toString());

        while(userContinue != -1 && !gameBoard.hasWinner()){
            userType = round % 2 == 0 ? "X" : "O";
            System.out.println("press which column to drop "+ userType +" (0-" + (col - 1) + "), -1 to stop game");
            userContinue = input.nextInt();
            if(gameBoard.canAdd(userContinue)){
                gameBoard.put(userContinue, userType);
            }else{
                System.out.println("you cannot add to this column");
                round--;
            }
            round++;
            System.out.println("current board: ");
            System.out.println(gameBoard.toString());
        }
        System.out.println("winner is " + gameBoard.getWinner());
    }
}
