import java.util.*;

public class TimeBasedKeyValueStore {

    static class Pair {

        int timestamp;
        String value;

        Pair(int t, String v) {

            timestamp = t;
            value = v;
        }
    }

    Map<String,
        List<Pair>> map;

    public TimeBasedKeyValueStore() {

        map = new HashMap<>();
    }

    public void set(String key,
                    String value,
                    int timestamp) {

        map.computeIfAbsent(
                key,
                k -> new ArrayList<>()
        ).add(new Pair(timestamp, value));
    }

    public String get(String key,
                      int timestamp) {

        if (!map.containsKey(key))
            return "";

        List<Pair> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;

        String result = "";

        while (left <= right) {

            int mid =
                    left + (right - left) / 2;

            if (list.get(mid).timestamp
                <= timestamp) {

                result =
                        list.get(mid).value;

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return result;
    }
}
