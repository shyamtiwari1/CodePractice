package Practice.SnakeLadder2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int size = 100;
        Map<Integer, Integer> snakes = new HashMap<Integer, Integer>();

        snakes.put(10, 0);
        Map<Integer , Integer> ladders = new HashMap<>();
        ladders.put(36,45 );
        Board board = new Board(100, snakes , ladders);

        Dice dice = new Dice(7);
        Queue<Player> players = new LinkedList<>();
        players.add(new Player("shyam"));
        players.add(new Player("ram"));
        Game game = new Game(board , players , dice);
        game.start();
    }
}
