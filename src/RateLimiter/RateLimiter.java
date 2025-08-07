package RateLimiter;

public class RateLimiter {
    private final RateLimitingStrategy strategy;

    public RateLimiter(RateLimitingStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean allowRequest(String userId) {
        return strategy.allowRequest(userId);
    }
}

