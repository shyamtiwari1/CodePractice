package MachineCoding.RateLimiter;

public class LeakyBucketRateLimiter implements RateLimiterStrategy{

    private int capacity ;
    private int tokens;
    private int leakRatePerSecond;
    private long lastLeakTime ;
//    private Queue<Integer>  queue;


    public LeakyBucketRateLimiter(int capacity , int leakRatePerSecond){
        this.tokens = tokens;
        this.leakRatePerSecond = leakRatePerSecond;
        this.capacity = capacity;
        this.lastLeakTime = System.currentTimeMillis()/1000;
//        queue = new LinkedList<>();

    }




    @Override
    public synchronized boolean allowRequest() {
        leak();
        if(tokens<capacity){
            tokens++;
            return true;

        }else{
            return false;
        }
    }

    private void leak() {
        long currTime = System.currentTimeMillis()/1000;
        long timeElapsed = currTime - lastLeakTime;

        int tokenProcessed = (int)(timeElapsed*leakRatePerSecond);

        tokens = Math.max(0, tokens-tokenProcessed);
        lastLeakTime = currTime;
    }
}
