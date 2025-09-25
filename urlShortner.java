import java.util.*;

class URLShortener {
    private Map<String, String> urlMap = new HashMap<>();
    private static final String BASE = "http://short.ly/";

    public String shorten(String longUrl) {
        String shortUrl = BASE + Integer.toHexString(longUrl.hashCode());
        urlMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    public String retrieve(String shortUrl) {
        return urlMap.get(shortUrl);
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();
        String shortUrl = shortener.shorten("https://github.com");
        System.out.println("Short URL: " + shortUrl);
        System.out.println("Original URL: " + shortener.retrieve(shortUrl));
    }
}
