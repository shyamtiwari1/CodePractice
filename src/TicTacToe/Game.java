package TicTacToe;

import java.util.Queue;
import java.util.Scanner;

public class Game {
    Board board;
    Queue<Player> playerQueue;

    public Game(Board board, Queue<Player> playerQueue) {
        this.board = board;
        this.playerQueue = playerQueue;
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        while(true){
            Player currPlayer = playerQueue.poll();

            board.printBoard();
            System.out.print("Enter row and column (0-" + (board.size-1) + "): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if(board.checkValidityAndPlaceMove(row, col , currPlayer.getSymbol())){

            }
            if(board.checkWin(currPlayer.getSymbol())){
                System.out.println(currPlayer.getName()+" won");
                break;
            }
            if(board.checkForDraw()){
                System.out.println("current game is draw , nobody won");
                break;
            }

            playerQueue.offer(currPlayer);

        }

        scanner.close();



    }


}
