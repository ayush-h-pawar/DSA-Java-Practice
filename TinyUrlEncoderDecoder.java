import java.util.*;

public class TinyUrlEncoderDecoder {

    Map<String, String> shortToLong;
    Map<String, String> longToShort;

    String baseUrl =
            "http://tinyurl.com/";

    String chars =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    Random random;

    public TinyUrlEncoderDecoder() {

        shortToLong = new HashMap<>();
        longToShort = new HashMap<>();

        random = new Random();
    }

    public String encode(String longUrl) {

        if (longToShort.containsKey(longUrl)) {

            return baseUrl +
                   longToShort.get(longUrl);
        }

        String key;

        do {

            StringBuilder sb =
                    new StringBuilder();

            for (int i = 0; i < 6; i++) {

                sb.append(
                        chars.charAt(
                                random.nextInt(
                                        chars.length()
                                )
                        )
                );
            }

            key = sb.toString();

        } while (shortToLong.containsKey(key));

        shortToLong.put(key, longUrl);
        longToShort.put(longUrl, key);

        return baseUrl + key;
    }

    public String decode(String shortUrl) {

        String key =
                shortUrl.substring(
                        baseUrl.length()
                );

        return shortToLong.get(key);
    }

    public static void main(String[] args) {

        TinyUrlEncoderDecoder tiny =
                new TinyUrlEncoderDecoder();

        String shortUrl =
                tiny.encode(
                        "https://google.com"
                );

        System.out.println(shortUrl);

        System.out.println(
                tiny.decode(shortUrl)
        );
    }
}
