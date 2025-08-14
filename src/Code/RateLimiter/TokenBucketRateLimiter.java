package Code.RateLimiter;

import java.util.HashMap;
import java.util.Map;

public class TokenBucketRateLimiter implements RateLimitingStrategy {

    private static class TokenBucket {
        int capacity;
        int refillRatePerSec;
        int tokens;
        long lastRefillTime;

        TokenBucket(int capacity, int refillRatePerSec) {
            this.capacity = capacity;
            this.refillRatePerSec = refillRatePerSec;
            this.tokens = capacity;
            this.lastRefillTime = System.currentTimeMillis() / 1000;
        }

        synchronized boolean allow() {
            refill();
            if (tokens > 0) {
                tokens--;
                return true;
            }
            return false;
        }

        private void refill() {
            long currentTime = System.currentTimeMillis() / 1000;
            long elapsed = currentTime - lastRefillTime;
            if (elapsed > 0) {
                int tokensToAdd = (int) (elapsed * refillRatePerSec);
                tokens = Math.min(capacity, tokens + tokensToAdd);
                lastRefillTime = currentTime;
            }
        }
    }

    private final int capacity;
    private final int refillRatePerSec;
    private final Map<String, TokenBucket> userBuckets = new HashMap<>();

    public TokenBucketRateLimiter(int capacity, int refillRatePerSec) {
        this.capacity = capacity;
        this.refillRatePerSec = refillRatePerSec;
    }

    @Override
    public boolean allowRequest(String userId) {
        userBuckets.putIfAbsent(userId, new TokenBucket(capacity, refillRatePerSec));
        return userBuckets.get(userId).allow();
    }
}

