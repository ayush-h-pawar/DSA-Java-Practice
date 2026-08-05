import java.util.HashMap;
import java.util.Map;

public class LRUCacheDesign {

    class Node {

        int key;
        int value;

        Node previous;
        Node next;

        Node(int key, int value) {

            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final Map<Integer, Node> cache;

    private final Node head;
    private final Node tail;

    public LRUCacheDesign(int capacity) {

        this.capacity = capacity;

        cache = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        remove(node);
        insert(node);

        return node.value;
    }

    public void put(
            int key,
            int value) {

        if (cache.containsKey(key)) {

            remove(cache.get(key));
        }

        Node node =
                new Node(key, value);

        cache.put(key, node);

        insert(node);

        if (cache.size() > capacity) {

            Node leastRecentlyUsed =
                    tail.previous;

            remove(leastRecentlyUsed);

            cache.remove(
                    leastRecentlyUsed.key
            );
        }
    }

    private void insert(Node node) {

        node.next = head.next;
        node.previous = head;

        head.next.previous = node;
        head.next = node;
    }

    private void remove(Node node) {

        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    public static void main(String[] args) {

        LRUCacheDesign cache =
                new LRUCacheDesign(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1));

        cache.put(3, 3);

        System.out.println(cache.get(2));

        cache.put(4, 4);

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
