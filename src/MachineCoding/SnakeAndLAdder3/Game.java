package MachineCoding.SnakeAndLAdder3;

import java.util.Queue;

public class Game {
    Board board;
    Queue<Player> players;
    Dice dice;

    public Game(Board board, Queue<Player> player, Dice dice) {
        this.board = board;
        this.players = player;
        this.dice = dice;
    }

    public void start() {

        boolean isgamewon = false ;

        while (!isgamewon) {
            Player player = players.poll();
            int roll = dice.roll();

            int currpos = player.getPosition();
            if(currpos+roll> board.getSize()){
                System.out.println(player.getName() +" won the game");
                isgamewon = true;
                break;
            }else{

                int nextpost = board.getNextPos(currpos+roll);
                player.setPosition(nextpost);
                players.offer(player);
            }

        }
    }
}
