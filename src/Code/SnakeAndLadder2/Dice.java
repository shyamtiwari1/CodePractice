package Code.SnakeAndLadder2;

import java.util.Random;

public class Dice {

    private int faces ;
    private Random random;

    public Dice(int i) {
        this.faces = i ;
        this.random = new Random();
    }


    public int roll(){
        return random.nextInt(faces)+1;
    }
}
