import java.util.*;

public class LFUCacheOptimized {

    class Node {

        int key, value, freq;

        Node(int k, int v) {

            key = k;
            value = v;
            freq = 1;
        }
    }

    int capacity;
    int minFreq;

    Map<Integer, Node> cache;
    Map<Integer,
        LinkedHashSet<Integer>> freqMap;

    public LFUCacheOptimized(int capacity) {

        this.capacity = capacity;

        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {

        if (!cache.containsKey(key))
            return -1;

        updateFreq(key);

        return cache.get(key).value;
    }

    public void put(int key, int value) {

        if (capacity == 0)
            return;

        if (cache.containsKey(key)) {

            cache.get(key).value = value;

            updateFreq(key);

            return;
        }

        if (cache.size() == capacity) {

            int evict =
                    freqMap.get(minFreq)
                           .iterator()
                           .next();

            freqMap.get(minFreq)
                   .remove(evict);

            cache.remove(evict);
        }

        Node node = new Node(key, value);

        cache.put(key, node);

        minFreq = 1;

        freqMap.computeIfAbsent(
                1,
                k -> new LinkedHashSet<>()
        ).add(key);
    }

    void updateFreq(int key) {

        Node node = cache.get(key);

        int freq = node.freq;

        freqMap.get(freq).remove(key);

        if (freq == minFreq &&
            freqMap.get(freq).isEmpty()) {

            minFreq++;
        }

        node.freq++;

        freqMap.computeIfAbsent(
                node.freq,
                k -> new LinkedHashSet<>()
        ).add(key);
    }
}
