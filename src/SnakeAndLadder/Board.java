package SnakeAndLadder;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Board {

    int size;

    Map<Integer , Integer> snake ;
    Map<Integer , Integer> ladder ;



    public Board(int size,Map<Integer , Integer> snake , Map<Integer , Integer> ladder   ){
        this.size   = size;
        this.snake = snake ;
        this.ladder = ladder;
    }

    public int getNextPos(int i) {

        if(snake.containsKey(i))return snake.get(i);
        if(ladder.containsKey(i))return ladder.get(i);
        return i ;

    }
}
