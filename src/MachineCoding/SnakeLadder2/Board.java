package MachineCoding.SnakeLadder2;

import java.util.Map;

public class Board {

    private int size;
    Map<Integer , Integer> snakes;
    Map<Integer , Integer> ladders;

    public Board(int i, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.size = i;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getNextPosition(int x) {
        if (snakes.containsKey(x)) {
            return snakes.get(x);
        }
        if (ladders.containsKey(x)) {
            return ladders.get(x);
        }
        return x;
    }

    public int getSize() {
        return size;
    }
}
