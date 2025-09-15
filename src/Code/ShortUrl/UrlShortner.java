package Code.ShortUrl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class UrlShortner {

    private static final String BASE62 =  "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int baselength = BASE62.length();

    private static final String domain = "http://shorturl/";

    private Map<String , String > longToShort = new HashMap<>();
    private Map<String , String > shortToLong = new HashMap<>();


    private  AtomicLong counter = new AtomicLong();

    public String encode(long num){
        StringBuilder sb = new StringBuilder();

        while(num>0){
            sb.append(BASE62.charAt((int)(num%baselength)));
            num/= baselength;
        }
        return sb.reverse().toString();

    }


    public String shortenUrl(String longurl){
        if(longurl.isEmpty())throw  new IllegalArgumentException("invalid url");

        if(longToShort.containsKey(longurl))return longToShort.get(longurl);

        long id = counter.getAndIncrement();
        String shortcode = encode(id);
        String shortUrl = domain+shortcode;

        longToShort.put(longurl , shortUrl);

        shortToLong.put(shortUrl  , longurl);
        return shortUrl;

    }

    public String getOriginalUrl(String shorturl){
        return shortToLong.get(shorturl);
    }


    public static void main(String args[]){

        UrlShortner urlShortner = new UrlShortner();
        String long1 = "leetcode/lrucache";

        String long2 = "leetcode/lrucache2";

        String short1 = urlShortner.shortenUrl(long1);
        String short2 = urlShortner.shortenUrl(long2);

        String short3 = urlShortner.shortenUrl(long1);

        System.out.println(short1);

        System.out.println(short2);
        System.out.println(short3);


    }



}
