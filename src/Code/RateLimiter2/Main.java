package Code.RateLimiter2;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        RateLimiterStrategy tokenBucketRateLimiter = new TokenBucketRateLimiter(10, 0);

        RateLimiter limiter = new RateLimiter(tokenBucketRateLimiter);

        String userId = "user123";

        for (int i = 0; i < 15; i++) {
            boolean allowed = limiter.allowRequest(userId);
            System.out.println("Request " + i + " → " + (allowed ? "Allowed" : "Denied"));
            Thread.sleep(200); // simulate 200ms delay
        }



    }
}
