package RateLimiter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimitingStrategy tokenBucket = new TokenBucketRateLimiter(10, 5);
        RateLimiter limiter = new RateLimiter(tokenBucket); // Plug-in your strategy here

        String userId = "user123";

        for (int i = 0; i < 15; i++) {
            boolean allowed = limiter.allowRequest(userId);
            System.out.println("Request " + i + " → " + (allowed ? "Allowed" : "Denied"));
            Thread.sleep(200); // simulate 200ms delay
        }



        RateLimitingStrategy leakyBucket = new LeakyBucketRateLimiter(5, 200);
        RateLimiter limiter1 = new RateLimiter(leakyBucket);

        String userId2 = "user456";

        for (int i = 0; i < 10; i++) {
            boolean allowed = limiter1.allowRequest(userId2);
            System.out.println("Request " + i + " → " + (allowed ? "Allowed" : "Denied"));
            Thread.sleep(100); // sending a request every 100ms
        }
    }
}


