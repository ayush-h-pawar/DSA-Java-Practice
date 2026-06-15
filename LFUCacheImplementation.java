import java.util.*;

public class LFUCacheImplementation {

    class Node {
        int key, value, freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> cache;
    private final Map<Integer, LinkedHashSet<Integer>> freqMap;

    public LFUCacheImplementation(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        Node node = cache.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        if (cache.size() == capacity) {
            LinkedHashSet<Integer> minFreqKeys = freqMap.get(minFreq);
            int evictKey = minFreqKeys.iterator().next();
            minFreqKeys.remove(evictKey);
            cache.remove(evictKey);
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        minFreq = 1;
        freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
    }

    private void updateFrequency(Node node) {
        int freq = node.freq;
        freqMap.get(freq).remove(node.key);

        if (freq == minFreq && freqMap.get(freq).isEmpty()) {
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node.key);
    }

    public static void main(String[] args) {
        LFUCacheImplementation cache = new LFUCacheImplementation(2);
        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1));
        cache.put(3, 30);
        System.out.println(cache.get(2));
    }
            }
