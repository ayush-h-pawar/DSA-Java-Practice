import java.util.*;

public class LFUCache {

    int capacity, minFreq;
    Map<Integer, Integer> keyToVal;
    Map<Integer, Integer> keyToFreq;
    Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {

        this.capacity = capacity;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        minFreq = 0;
    }

    public int get(int key) {

        if (!keyToVal.containsKey(key))
            return -1;

        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        freqToKeys.get(freq).remove(key);

        if (freq == minFreq && freqToKeys.get(freq).isEmpty())
            minFreq++;

        freqToKeys
            .computeIfAbsent(freq + 1, k -> new LinkedHashSet<>())
            .add(key);

        return keyToVal.get(key);
    }

    public void put(int key, int value) {

        if (capacity == 0) return;

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key);
            return;
        }

        if (keyToVal.size() >= capacity) {

            int evict = freqToKeys.get(minFreq).iterator().next();
            freqToKeys.get(minFreq).remove(evict);
            keyToVal.remove(evict);
            keyToFreq.remove(evict);
        }

        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        minFreq = 1;

        freqToKeys
            .computeIfAbsent(1, k -> new LinkedHashSet<>())
            .add(key);
    }
}
