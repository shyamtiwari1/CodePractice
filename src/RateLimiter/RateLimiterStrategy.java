package RateLimiter;

public interface RateLimiterStrategy {

    boolean allowRequest();
}
