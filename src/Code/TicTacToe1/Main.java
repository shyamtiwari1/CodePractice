package Code.TicTacToe1;


import java.util.LinkedList;
import java.util.Queue;

public class Main {


    public static void main(String args[]){

        Queue<Player> playerList = new LinkedList<>();
        playerList.add(new Player("Shyam" , Symbol.X));
        playerList.add(new Player("Ram" , Symbol.O));
        playerList.add(new Player("Shyam" , Symbol.X));



        Board board = new Board(6);


        Game game = new Game(board , playerList);
        game.start();

    }}
