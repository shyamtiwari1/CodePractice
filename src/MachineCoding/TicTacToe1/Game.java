package MachineCoding.TicTacToe1;

import java.util.Queue;
import java.util.Scanner;

public class Game {

    Board board;
    Queue<Player> playerList;




    public Game(Board board ,Queue<Player> playerList ){
        this.board = board ;
        this.playerList = playerList;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            Player currPlayer = playerList.poll();

            board.printBoard();
            System.out.println(currPlayer.getName()+" turn");
            int row = scanner.nextInt();
            int column = scanner.nextInt();

            if(!board.placeSymbol(row , column , currPlayer)){
                System.out.println("invalid move");
                continue;
            }
            if(board.checkWin(currPlayer.getSymbol())){
                System.out.println(currPlayer.getName() +" won");
                break;
            }
            if(board.isFull()){
                System.out.println("match is draw");
                break;

            }
            playerList.offer(currPlayer);
        }
    }

}
