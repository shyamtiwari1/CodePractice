package MachineCoding.RateLimiter2;

import java.util.HashMap;
import java.util.Map;

public class TokenBucketRateLimiter implements RateLimiterStrategy {

    public static class TokenBucket{
        int capacity;
        int tokens ;
        int refillRate;
        long lastrefilltime;


        public TokenBucket(int capacity,  int refillRate){

            this.capacity = capacity;
            this.refillRate = refillRate;

            this.tokens = capacity;
            this.lastrefilltime = System.currentTimeMillis();
        }

        public boolean allow(){
            refill();
            if(tokens>0){
                tokens--;
                return true;
            }
            return false;
        }

        public void refill(){
            long timenow = System.currentTimeMillis();
            long timeelapsed = timenow- lastrefilltime;
            int tokenToAdd = (int)timeelapsed*refillRate;
            tokens = Math.min(capacity,tokenToAdd+tokens);
            lastrefilltime = timenow;
        }
    }

    int capacity;
    int refillRate;
    Map<String , TokenBucket> userBuckets = new HashMap<>();

    public TokenBucketRateLimiter(int capacity, int refillRate){
        this.capacity = capacity;
        this.refillRate = refillRate;
    }




    @Override
    public boolean allowRequest(String userId) {
        userBuckets.putIfAbsent(userId , new TokenBucket(capacity, refillRate));
        return userBuckets.get(userId).allow();

    }
}
