import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore1 {

    static class Entry {

        String value;
        int timestamp;

        Entry(
                String value,
                int timestamp) {

            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private final Map<String, List<Entry>> store;

    public TimeBasedKeyValueStore() {

        store = new HashMap<>();
    }

    public void set(
            String key,
            String value,
            int timestamp) {

        store.computeIfAbsent(
                key,
                k -> new ArrayList<>()
        ).add(
                new Entry(
                        value,
                        timestamp
                )
        );
    }

    public String get(
            String key,
            int timestamp) {

        if (!store.containsKey(key)) {
            return "";
        }

        List<Entry> entries =
                store.get(key);

        int left = 0;
        int right = entries.size() - 1;

        String answer = "";

        while (left <= right) {

            int middle =
                    left + (right - left) / 2;

            if (entries.get(middle).timestamp
                    <= timestamp) {

                answer =
                        entries.get(middle).value;

                left = middle + 1;

            } else {

                right = middle - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        TimeBasedKeyValueStore store =
                new TimeBasedKeyValueStore();

        store.set(
                "foo",
                "bar",
                1
        );

        System.out.println(
                store.get(
                        "foo",
                        1
                )
        );

        System.out.println(
                store.get(
                        "foo",
                        3
                )
        );

        store.set(
                "foo",
                "bar2",
                4
        );

        System.out.println(
                store.get(
                        "foo",
                        4
                )
        );

        System.out.println(
                store.get(
                        "foo",
                        5
                )
        );
    }
}
