package MachineCoding.RateLimiter_4;

public interface RateLimitingStrategy {
    boolean allowRequest(String userId);
}
