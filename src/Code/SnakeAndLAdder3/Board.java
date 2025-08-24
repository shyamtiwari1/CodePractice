package Code.SnakeAndLAdder3;

import java.util.Map;

public class Board {
    int size;
    Map<Integer , Integer> snakes ;
    Map<Integer , Integer> ladders ;

    public Board(int size) {
        this.size = size;
    }

    public Board(int size, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize() {
        return size;
    }

    public int getNextPos(int i) {

        if(snakes.containsKey(i)){
            return snakes.get(i);
        }
        if(ladders.containsKey(i)){
            return ladders.get(i);
        }
        return i ;
    }
}
