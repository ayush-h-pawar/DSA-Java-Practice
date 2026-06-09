import java.util.*;

public class InsertDeleteGetRandomO1 {

    private List<Integer> values;

    private Map<Integer, Integer> indexMap;

    private Random random;

    public InsertDeleteGetRandomO1() {

        values = new ArrayList<>();

        indexMap = new HashMap<>();

        random = new Random();
    }

    public boolean insert(int val) {

        if (indexMap.containsKey(val)) {
            return false;
        }

        values.add(val);

        indexMap.put(
                val,
                values.size() - 1
        );

        return true;
    }

    public boolean remove(int val) {

        if (!indexMap.containsKey(val)) {
            return false;
        }

        int index =
                indexMap.get(val);

        int lastElement =
                values.get(
                        values.size() - 1
                );

        values.set(
                index,
                lastElement
        );

        indexMap.put(
                lastElement,
                index
        );

        values.remove(
                values.size() - 1
        );

        indexMap.remove(val);

        return true;
    }

    public int getRandom() {

        int randomIndex =
                random.nextInt(
                        values.size()
                );

        return values.get(
                randomIndex
        );
    }

    public static void main(String[] args) {

        InsertDeleteGetRandomO1 ds =
                new InsertDeleteGetRandomO1();

        System.out.println(
                ds.insert(1)
        );

        System.out.println(
                ds.insert(2)
        );

        System.out.println(
                ds.remove(1)
        );

        System.out.println(
                ds.getRandom()
        );
    }
}
