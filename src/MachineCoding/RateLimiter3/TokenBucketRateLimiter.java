package MachineCoding.RateLimiter3;

public class TokenBucketRateLimiter implements RateLimiterStrategy {


    private final int capacity ;
    private final int refillRatePerSecond;

    private double tokens;
    private long lastRefillingTimeStamps;

    public TokenBucketRateLimiter(int capacity, int refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.tokens = capacity;
        this.lastRefillingTimeStamps = System.currentTimeMillis();
    }


    @Override
    public boolean allowedRequest() {
        refill();
        if(tokens>=1){
            tokens-=1;
            return true;
        }
        return false;
    }

    private void refill() {

        long now =  System.currentTimeMillis();
        long timesinceLastRefill = now - lastRefillingTimeStamps;

        double tokensToadd = tokens +  (refillRatePerSecond/1000)*timesinceLastRefill;
        if(tokens>0){
            lastRefillingTimeStamps = now;
            tokens = Math.min(tokens+tokensToadd, capacity);
        }

    }
}
