package MachineCoding.SnakeAndLadder_1;


import java.util.Map;

public class Board {

    int size = 100;

    Map<Integer , Integer> snakes ;//key : mouth , value : tail
    Map<Integer , Integer> ladders ;//key ; start , value : end

    Board(int size , Map<Integer , Integer> snakes , Map<Integer , Integer> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }


    public void addSnake(int start , int end) {
        snakes.put(start , end);
    }

    public void addLadder(int start, int end ) {
        ladders.put(start , end);

    }

    public int getNextPos(int start) {
        if(snakes.containsKey(start)){
            return snakes.get(start);
        }
        if(ladders.containsKey(start)){
            return ladders.get(start);
        }
        return start;
    }
}
