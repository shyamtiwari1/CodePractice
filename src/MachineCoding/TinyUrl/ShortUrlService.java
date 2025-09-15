package MachineCoding.TinyUrl;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;


public class ShortUrlService {


    public static final String base62 ="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int baseLength = base62.length();

    public static final String DOMAIN ="http://shorturl/";

    private AtomicLong counter = new AtomicLong();


    Map<String , String > shortToLong;
    Map<String , String > longToShort;


    public ShortUrlService(){
        shortToLong = new HashMap<>();
        longToShort = new HashMap<>();

    }

    public String encodeBase62(long num){
        StringBuilder sb = new StringBuilder();

        while(num!=0){
            sb.append(base62.charAt((int)num%baseLength));
            num/=baseLength;
        }
        return sb.toString();



    }


    public String getShortUrl(String longUrl){
        if(longToShort.containsKey(longUrl))return longToShort.get(longUrl);

        long id = counter.getAndIncrement();
        String shortUrl = DOMAIN+ encodeBase62(id);
        longToShort.put(longUrl ,shortUrl );
        shortToLong.put(shortUrl,longUrl);
        return shortUrl;
    }


    public String  getOriginalUrl(String shortUrl){
        if(shortToLong.containsKey(shortUrl))return shortToLong.get(shortUrl);
        throw new NoSuchElementException("url not found");
    }

}
