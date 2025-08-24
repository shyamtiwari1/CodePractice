package Code.SnakeAndLAdder3;

import java.util.Random;

public class Dice {

    int faces ;
    Random random;


    public Dice(int faces){
        this.faces = faces;
        this.random = new Random();
    }

    public int roll(){
        return   1+ random.nextInt(faces);
    }
}
