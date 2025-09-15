package MachineCoding.RateLimiter3;

public class RateLimiter {



    RateLimiterStrategy strategy;
    public RateLimiter(RateLimiterStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean allowedRequest() {
        return strategy.allowedRequest();
    }



}
