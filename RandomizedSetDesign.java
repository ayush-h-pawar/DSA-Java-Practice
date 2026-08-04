import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSetDesign {

    private final List<Integer> values;
    private final Map<Integer, Integer> indexMap;
    private final Random random;

    public RandomizedSetDesign() {

        values = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(
            int value) {

        if (indexMap.containsKey(value)) {
            return false;
        }

        values.add(value);

        indexMap.put(
                value,
                values.size() - 1
        );

        return true;
    }

    public boolean remove(
            int value) {

        if (!indexMap.containsKey(value)) {
            return false;
        }

        int removeIndex =
                indexMap.get(value);

        int lastValue =
                values.get(values.size() - 1);

        values.set(
                removeIndex,
                lastValue
        );

        indexMap.put(
                lastValue,
                removeIndex
        );

        values.remove(
                values.size() - 1
        );

        indexMap.remove(value);

        return true;
    }

    public int getRandom() {

        return values.get(
                random.nextInt(
                        values.size()
                )
        );
    }

    public static void main(String[] args) {

        RandomizedSetDesign randomizedSet =
                new RandomizedSetDesign();

        System.out.println(
                randomizedSet.insert(1)
        );

        System.out.println(
                randomizedSet.remove(2)
        );

        System.out.println(
                randomizedSet.insert(2)
        );

        System.out.println(
                randomizedSet.getRandom()
        );

        System.out.println(
                randomizedSet.remove(1)
        );

        System.out.println(
                randomizedSet.insert(2)
        );

        System.out.println(
                randomizedSet.getRandom()
        );
    }
}
