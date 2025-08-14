package Code.SnakeAndLadder2;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(100);
        board.addSnake(99, 5);
        board.addSnake(70, 55);
        board.addSnake(52, 42);
        board.addLadder(2, 23);
        board.addLadder(10, 90);
        board.addLadder(25, 47);

        Dice dice = new Dice(6);

        Queue<Player> players = new LinkedList<>();
        players.offer(new Player("Alice"));
        players.offer(new Player("Bob"));

        Game game = new Game(board, dice, players);
        game.start();
    }
}

