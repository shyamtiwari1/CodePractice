package MachineCoding.SnakeAndLadder;

import java.util.Queue;

public class Game {

    Board board ;
    Dice dice ;
    Queue<Player> playerQueue ;


    public Game(Board board, Dice dice, Queue<Player> playerQueue) {
        this.board = board;
        this.dice = dice;
        this.playerQueue = playerQueue;
    }

    public void start() {


        boolean isGameWon = false;

        while(!isGameWon){
            Player currPlayer = playerQueue.poll();
            int currpos = currPlayer.getPosition();
            int rolledint = dice.roll();
            System.out.println(currPlayer.getName()+"rolled "+rolledint);
            int nextPos = currpos+rolledint;
            if(nextPos>board.size){

            }else{
                 nextPos = board.getNextPos(nextPos);
                if(nextPos== board.size){
                    isGameWon = true;
                    System.out.println(currPlayer.getName() +" won");
                    break;
                }
                currPlayer.setPosition(nextPos);
            }
            playerQueue.offer(currPlayer);

        }
    }
}
