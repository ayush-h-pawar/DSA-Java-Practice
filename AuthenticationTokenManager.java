import java.util.HashMap;
import java.util.Map;

public class AuthenticationTokenManager {

    private final int timeToLive;

    private final Map<String, Integer> expiryTime =
            new HashMap<>();

    public AuthenticationTokenManager(
            int timeToLive) {

        this.timeToLive = timeToLive;
    }

    public void generate(
            String tokenId,
            int currentTime) {

        expiryTime.put(
                tokenId,
                currentTime + timeToLive
        );
    }

    public void renew(
            String tokenId,
            int currentTime) {

        Integer expiry =
                expiryTime.get(tokenId);

        if (expiry == null
                || expiry <= currentTime) {

            return;
        }

        expiryTime.put(
                tokenId,
                currentTime + timeToLive
        );
    }

    public int countUnexpiredTokens(
            int currentTime) {

        int count = 0;

        for (int expiry :
                expiryTime.values()) {

            if (expiry > currentTime) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        AuthenticationTokenManager manager =
                new AuthenticationTokenManager(5);

        manager.generate(
                "token1",
                1
        );

        manager.generate(
                "token2",
                2
        );

        System.out.println(
                manager.countUnexpiredTokens(6)
        );

        manager.renew(
                "token1",
                6
        );

        System.out.println(
                manager.countUnexpiredTokens(7)
        );
    }
}
