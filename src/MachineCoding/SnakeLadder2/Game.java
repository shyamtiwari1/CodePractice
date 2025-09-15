package MachineCoding.SnakeLadder2;

import java.util.LinkedList;
import java.util.Queue;

public class Game {

    private Board board;

    private Queue<Player> playerQueue = new LinkedList<>();

    private Dice dice;


    public Game(Board board, Queue<Player> players, Dice dice) {
        this.board = board;
        this.playerQueue = players;
        this.dice = dice;
    }

    public void start() {

        boolean gameOver = false;


        while (!gameOver) {
            Player currentPlayer = playerQueue.poll();
            int currpos = currentPlayer.getPosition();
            int x = dice.roll();
            System.out.println(currentPlayer+" rolled "+x);
            int pos = currpos+x;
            if(pos>board.getSize()){
                System.out.println("invalid doce roll");
            }else{
                int nextpos = board.getNextPosition(pos);

                if(nextpos== board.getSize()){
                    System.out.println(currentPlayer.getName()+" won");
                    gameOver = true;
                    break;
                }
                currentPlayer.setPosition(nextpos);
            }
            playerQueue.offer(currentPlayer);
        }
    }
}
