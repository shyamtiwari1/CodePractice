package Code.SnakeAndLadder;
import java.util.random.RandomGenerator;

public class Dice {

    int diceCount;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }


    int rollDice(){
        int sum  = 0 ;
        while(diceCount !=0){
            sum+= RandomGenerator.getDefault().nextInt();
        }
        return sum;
    }
}
