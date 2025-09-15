package Code.MultiThreading;

public class Synchronisedcounter {

    public int count = 0 ;

    public synchronized void incrememnt(){
         count++;
    }

    public synchronized int getCount(){
        return count;
    }
}
