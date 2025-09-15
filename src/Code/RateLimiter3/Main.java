package Code.RateLimiter3;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        RateLimiter limiter = new RateLimiter(new TokenBucketRateLimiter(2, 1));

        RateLimiter leakyBucketLimiter = new RateLimiter(new LeakyBucketRateLimiter(2, 1));
        for (int i = 0; i < 30; i++) {
            boolean allowed = limiter.allowedRequest();
            System.out.println("token bucket Request " + i + " allowed: " + allowed);
            Thread.sleep(1000);
        }

        for(int i = 0 ; i <10 ;i++){
            boolean allowed =  leakyBucketLimiter.allowedRequest();
            System.out.println("leaky bucket Request " + i + " allowed: " + allowed);
            Thread.sleep(1000);

        }
    }







}
