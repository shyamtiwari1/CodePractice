package MachineCoding.TinyUrl;

public class Main {

    public static void main(String args[]){

        String s1 = " abjdbwhubcihedsc";
        String s2 = " abjdbwhubcihedss";
        String s3 = " abjdbwhubcihedsc";

        ShortUrlService shortUrlService  = new ShortUrlService();


        System.out.println(shortUrlService.getShortUrl(s1));
        System.out.println(shortUrlService.getOriginalUrl(shortUrlService.getShortUrl(s1)));
        System.out.println(shortUrlService.getShortUrl(s2));
        System.out.println(shortUrlService.getShortUrl(s3));



    }
}
