package RateLimiter;

public class Main {

    public static void main(String[] args){

        RateLimiterStrategy rateLimiterStrategy = new TokenBucketRateLimiter(5, 1);

        RateLimiterStrategy rateLimiterStrategy1 = new LeakyBucketRateLimiter(5,1);


//        for(int i = 1 ;i<=20;i++){
//            if(rateLimiterStrategy.allowRequest()){
//                System.out.println("request "+i+" succeed");
//            }else{
//                System.out.println("request "+i+" failed");
//            }
//            try{
//                Thread.sleep(500);
//            }catch (Exception e){
//
//
//            }
//        }


        for (int i = 1; i <= 15; i++) {
            boolean allowed = rateLimiterStrategy1.allowRequest();
            System.out.println("Request " + i + " => " + (allowed ? "ACCEPTED" : "REJECTED"));

            // simulate random interval between requests
            try {
                Thread.sleep(300); // 300ms between requests
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



    }}
