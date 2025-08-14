package Code.RateLimiter2;

public interface RateLimiterStrategy {


    public boolean allowRequest(String userId);
}
