package MachineCoding.SnakeAndLadder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {


    public static void main(String args[]){


        Map<Integer , Integer> snakes = new HashMap<>();

        snakes.put(99,10);
        snakes.put(73,34);
        snakes.put(34,1);
        snakes.put(46,22);
        Map<Integer , Integer> ladder = new HashMap<>();
        ladder.put(7 , 90);
        ladder.put(54 , 65);
        ladder.put(69, 70);
        Dice dice = new Dice(6);


        Queue<Player> playerQueue = new LinkedList<>();
        playerQueue.add(new Player("shyam"));
        playerQueue.add(new Player("ram"));

        Board board = new Board(100 , snakes , ladder);



        Game game = new Game(board , dice , playerQueue);

        game.start();

    }


}
