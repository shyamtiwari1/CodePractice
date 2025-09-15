package Code.RateLimiter3;

public class FixedWindowRateLimiter implements RateLimiterStrategy{

    private final int maxRequest;
    private final int maxWindowSizeinMilis;

    private long windowstart;
    private long requestcount;


    public FixedWindowRateLimiter(int maxRequest, int maxWindowSizeinMilis) {
        this.maxRequest = maxRequest;
        this.maxWindowSizeinMilis = maxWindowSizeinMilis;
        this.windowstart = System.currentTimeMillis();
        this.requestcount = 0;
    }

    @Override
    public synchronized boolean allowedRequest() {
        long now =  System.currentTimeMillis();

        if(now-windowstart>=maxWindowSizeinMilis){
            windowstart = now;
            requestcount = 0;
        }

        if(requestcount<maxRequest){
            requestcount++;
            return true;
        }
        return false;


    }



}
