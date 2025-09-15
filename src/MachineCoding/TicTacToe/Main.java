package MachineCoding.TicTacToe;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String args[]){

        Queue<Player> playerQueue = new LinkedList<>();
        playerQueue.add(new Player("shyam" , Symbol.X));
        playerQueue.add(new Player("ram" , Symbol.O));

        Game game = new Game(new Board(3) , playerQueue);

        game.start();





    }
}
