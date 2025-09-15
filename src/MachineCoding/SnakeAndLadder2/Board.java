package MachineCoding.SnakeAndLadder2;

import java.util.HashMap;
import java.util.Map;

public class Board {


    public int size;

    private Map<Integer , Integer> snakes ;// key :head , value : tail
    private Map<Integer , Integer> ladder; // key : start , value top

    public Board(int size) {
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladder = new HashMap<>();
    }


    public void addSnake(int head , int tail){
        snakes.put(head , tail);
    }

    public void addLadder(int bottom , int top){
        ladder.put(bottom , top);
    }

    public int getSize() {
            return size;
    }

    public int getNextPosition(int position){
        if(snakes.containsKey(position)){
            System.out.println("opps bitten by snake");
            return snakes.get(position);
        }

        if (ladder.containsKey(position)) {
            System.out.println("Yay! Climbed a ladder.");
            return ladder.get(position);
        }
        return position;
    }

    }





