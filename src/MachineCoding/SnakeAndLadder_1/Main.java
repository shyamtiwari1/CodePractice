package MachineCoding.SnakeAndLadder_1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int n = 200;
        Map<Integer, Integer> snakes = new HashMap<>();
        Map<Integer, Integer> ladders = new HashMap<>();
        Board board = new Board(n, snakes , ladders);


        board.addSnake(14, 5);
        board.addSnake(44, 33);
        board.addSnake(55,36);
        board.addSnake(99, 3);
        board.addLadder(10, 90);
        board.addLadder(16, 50);
        board.addLadder(19, 60);
        board.addLadder(78, 83);


        Queue<Player> players = new LinkedList<>();

        players.add(new Player("shyam"));
        players.add(new Player("apoorva"));
        Dice dice = new Dice(6);


        Game game = new Game(board , players , dice);
        game.start();


    }
}
