package Practice.SnakeLadder2;

import java.util.Random;

public class Dice {

    private int faces;
    Random rand;


    public Dice(int faces){
        this.faces = faces;
        rand = new Random();

    }



    public int roll(){
        return rand.nextInt(faces)+1;
    }
}
