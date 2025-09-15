package MachineCoding.SnakeAndLadder_1;

import java.util.Random;

public class Dice {

    int faces ;
    Random rand ;

    public Dice(int i) {
        this.faces = i;
        this.rand = new Random();
    }


    public int roll(){
        return rand.nextInt(faces)+1;
    }
}
