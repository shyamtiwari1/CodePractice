package MachineCoding.SnakeAndLAdder3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {


        Map<Integer , Integer> snakes = new HashMap();

        Map<Integer , Integer> ladders  = new HashMap();

        snakes.put(92, 5 );
        snakes.put(55, 20 );
        snakes.put(34, 0 );
        ladders.put(9, 93 );
        ladders.put(18, 56 );
        ladders.put(71, 99 );


        Board board = new Board(100 , snakes , ladders);

        Queue<Player> player = new LinkedList<>();

        player.add(new Player("shyam"));
        player.add(new Player("apoorva"));
        Dice dice = new Dice(6);

        Game  game = new Game(board , player , dice );;

        game.start();



    }
}
