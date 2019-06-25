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
        int userContinue;
        GameBoard gameBoard = new GameBoard(row, col);
        int round = 0;
        String userType;
        do {
            if(round % 2 == 0){
                userType = "X";
            }else{
                userType = "O";
            }
            System.out.println("press which column to drop "+ (round % 2 == 0 ? "X" : "O") +" (0-" + (col - 1) + "), -1 to stop game");
            userContinue = input.nextInt();
            gameBoard.put(userContinue, userType);
            round++;
        } while (userContinue != -1 || gameBoard.hasWinner());
        System.out.println("winner is " + gameBoard.getWinner());
    }
}
