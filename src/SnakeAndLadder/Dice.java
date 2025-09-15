package SnakeAndLadder;

import java.util.Random;

public class Dice {

    int faces ;
    Random random;

    public Dice(int face){
        this.faces = face;
        random = new Random();

    }

    public int roll(){
        return random.nextInt(faces)+1;
    }
}
