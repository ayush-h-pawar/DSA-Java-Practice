import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPriceTracker {

    private final Map<Integer, Integer> prices =
            new HashMap<>();

    private final TreeMap<Integer, Integer> frequency =
            new TreeMap<>();

    private int latestTimestamp = 0;

    public void update(
            int timestamp,
            int price) {

        if (prices.containsKey(timestamp)) {

            int oldPrice =
                    prices.get(timestamp);

            removePrice(oldPrice);
        }

        prices.put(timestamp, price);

        frequency.put(
                price,
                frequency.getOrDefault(
                        price,
                        0
                ) + 1
        );

        latestTimestamp =
                Math.max(
                        latestTimestamp,
                        timestamp
                );
    }

    public int current() {

        return prices.get(latestTimestamp);
    }

    public int maximum() {

        return frequency.lastKey();
    }

    public int minimum() {

        return frequency.firstKey();
    }

    private void removePrice(int price) {

        int count =
                frequency.get(price);

        if (count == 1) {

            frequency.remove(price);

        } else {

            frequency.put(
                    price,
                    count - 1
            );
        }
    }

    public static void main(String[] args) {

        StockPriceTracker tracker =
                new StockPriceTracker();

        tracker.update(1, 10);
        tracker.update(2, 5);

        System.out.println(
                tracker.current()
        );

        System.out.println(
                tracker.maximum()
        );

        tracker.update(1, 3);

        System.out.println(
                tracker.maximum()
        );

        tracker.update(4, 2);

        System.out.println(
                tracker.minimum()
        );
    }
}
