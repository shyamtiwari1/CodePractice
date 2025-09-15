package Code.RateLimiter3;

public class LeakyBucketRateLimiter implements RateLimiterStrategy{

    private final int capacity;
    private final int leakingRatePersecond;

    private  double tokens ;
    private  long lastLeakTime;


    public LeakyBucketRateLimiter(int capacity, int leakingRatePersecond) {
        this.capacity = capacity;
        this.leakingRatePersecond = leakingRatePersecond;
        tokens = 0;
        lastLeakTime = System.currentTimeMillis();
    }


    @Override
    public boolean allowedRequest() {
        leak();
        if(tokens<capacity){
            tokens+=1;
            return true;
        }
        return false;
    }

    private void leak() {
        long now  = System.currentTimeMillis();
        double secondsSinceLastLeak =  (now - lastLeakTime)/1000.0;
        double tokenToLeak = (leakingRatePersecond * secondsSinceLastLeak);

        if(tokenToLeak>0){
            tokens = Math.max(0, tokens- tokenToLeak);
            lastLeakTime = now;
        }

    }


}
