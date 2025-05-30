package SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Board board;
    Dice dice;
    Deque<Players> playerList = new LinkedList<>();
    Players winner;


    public Game(){
        initialiseGame();
    }

    private void initialiseGame() {

         board = new Board(10,5,4);
         dice = new Dice(1);
         winner = null ; 
         addPlayer();
    }

    private void addPlayer() {
    }

    public void startGame() {
    }
}
