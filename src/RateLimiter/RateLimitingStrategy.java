package RateLimiter;

public interface RateLimitingStrategy {
    boolean allowRequest(String userId);
}
