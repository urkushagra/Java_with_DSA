import java.util.*;

class AuthenticationManager {

    private int ttl;
    private Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
        this.map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + ttl);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            int expiry = map.get(tokenId);

            if (expiry > currentTime) {
                map.put(tokenId, currentTime + ttl);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() <= currentTime) {
                it.remove();
            }
        }

        return map.size();
    }
}
