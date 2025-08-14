package Practice.SnakeAndLadder;




import java.util.List;
import java.util.Queue;

public class Game {

    Board board;
    Queue<Player> playerQueue;
    Dice dice;


    public Game(Board board, Queue<Player> playerQueue, Dice dice) {

        this.board = board;
        this.playerQueue = playerQueue;
        this.dice = dice;
    }


    public void start() {

        boolean gameOver = false;

        while (!gameOver) {

            Player player = playerQueue.poll();

            int  x = dice.roll();
            int currPosition = player.getPosition();

            int pos = currPosition+x;
            if(pos> board.size){
                System.out.println("position out of bounds");
//                System.out.println(player.getName()+" won the game");
            }else{
                int newpos = board.getNextPos(pos);
                player.setPosition(newpos);
                System.out.println(player.getName()+" is moved to position "+newpos);
                if(newpos == board.size){
                    gameOver = true;
                    System.out.println("Game over "+ player.getName()+"won");
                    break;
                }
            }
            playerQueue.offer(player);
        }



    }


}
