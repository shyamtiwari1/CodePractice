package SnakeAndLadder2;

import com.sun.source.tree.WhileLoopTree;

import java.util.Queue;

public class Game {

    private Board board;
    private Dice dice;
    private Queue<Player> playerQueue;


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public Queue<Player> getPlayerQueue() {
        return playerQueue;
    }

    public void setPlayerQueue(Queue<Player> playerQueue) {
        this.playerQueue = playerQueue;
    }

    public Game(Board board , Dice dice , Queue<Player> playerQueue){

        this.board = board;
        this.dice = dice;
        this.playerQueue = playerQueue;

    }

    public void start(){
        boolean isGameWon = false;

        while (!isGameWon){

            Player currentPlayer = playerQueue.poll();

            int roll = dice.roll();

            System.out.println(currentPlayer.getName() + " rolled a" + roll);

            int nextPos = currentPlayer.getPosition() +roll;

            if(nextPos > board.getSize()){
                System.out.println("Roll exceeds board size , skipping the move");
            }else{
                int pos = board.getNextPosition(nextPos);
                currentPlayer.setPosition(pos);
                System.out.println(currentPlayer.getName() + " moved to " + pos);

                if (pos == board.getSize()) {
                    System.out.println(currentPlayer.getName() + " wins the game!");
                    isGameWon = true;
                    break;
                }
            }

            playerQueue.offer(currentPlayer);

        }
    }


}
