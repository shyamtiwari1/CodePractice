package RateLimiter;

public class TokenBucketRateLimiter implements RateLimiterStrategy{


    private int capacity;
    private int refillRatePerSecond;
    private int token ;
    private long lastRefillTime;



    public TokenBucketRateLimiter(int capacity ,int refillRatePerSecond){
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.token = capacity;
        this.lastRefillTime = System.currentTimeMillis();

    }


    @Override
    public synchronized  boolean allowRequest() {
        refill();

        if(token>1){
            token-=1;
            return true;
        }else{
            return false;
        }
    }

    private void refill() {

        long currTime = System.currentTimeMillis();
        long totalTimeSinceLastRefill = (currTime - lastRefillTime)/1000;

        if(totalTimeSinceLastRefill>0){
            int tokensToAdd = (int) ((int)refillRatePerSecond*totalTimeSinceLastRefill);
            if(token+tokensToAdd>capacity){
                token = capacity;
            } else{
                token+=tokensToAdd;
            }
            lastRefillTime = currTime;
        }

    }
}
