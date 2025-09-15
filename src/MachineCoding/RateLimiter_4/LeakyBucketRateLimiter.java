package MachineCoding.RateLimiter_4;

import java.util.*;

public class LeakyBucketRateLimiter implements RateLimitingStrategy {

    private static class LeakyBucket {
        int capacity;
        long leakIntervalMillis;
        Queue<Long> queue = new LinkedList<>();
        long lastLeakTime;

        LeakyBucket(int capacity, long leakIntervalMillis) {
            this.capacity = capacity;
            this.leakIntervalMillis = leakIntervalMillis;
            this.lastLeakTime = System.currentTimeMillis();
        }

        synchronized boolean allow() {
            leak();

            if (queue.size() < capacity) {
                queue.offer(System.currentTimeMillis());
                return true;
            }
            return false;
        }

        private void leak() {
            long now = System.currentTimeMillis();
            long elapsed = now - lastLeakTime;

            long tokensToLeak = elapsed / leakIntervalMillis;
            for (int i = 0; i < tokensToLeak && !queue.isEmpty(); i++) {
                queue.poll(); // remove oldest
            }

            if (tokensToLeak > 0) {
                lastLeakTime = now;
            }
        }
    }

    private final int capacity;
    private final long leakIntervalMillis;
    private final Map<String, LeakyBucket> userBuckets = new HashMap<>();

    public LeakyBucketRateLimiter(int capacity, long leakIntervalMillis) {
        this.capacity = capacity;
        this.leakIntervalMillis = leakIntervalMillis;
    }

    @Override
    public boolean allowRequest(String userId) {
        userBuckets.putIfAbsent(userId, new LeakyBucket(capacity, leakIntervalMillis));
        return userBuckets.get(userId).allow();
    }
}

