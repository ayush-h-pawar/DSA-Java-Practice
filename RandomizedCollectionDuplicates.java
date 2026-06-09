import java.util.*;

public class RandomizedCollectionDuplicates {

    private List<Integer> values;

    private Map<Integer, Set<Integer>> indexMap;

    private Random random;

    public RandomizedCollectionDuplicates() {

        values = new ArrayList<>();

        indexMap = new HashMap<>();

        random = new Random();
    }

    public boolean insert(int val) {

        boolean notPresent =
                !indexMap.containsKey(val);

        indexMap.computeIfAbsent(
                val,
                k -> new HashSet<>()
        );

        indexMap.get(val)
                .add(values.size());

        values.add(val);

        return notPresent;
    }

    public boolean remove(int val) {

        if (!indexMap.containsKey(val) ||
            indexMap.get(val).isEmpty()) {

            return false;
        }

        int removeIndex =
                indexMap.get(val)
                        .iterator()
                        .next();

        int lastValue =
                values.get(
                        values.size() - 1
                );

        values.set(
                removeIndex,
                lastValue
        );

        indexMap.get(val)
                .remove(removeIndex);

        indexMap.get(lastValue)
                .add(removeIndex);

        indexMap.get(lastValue)
                .remove(values.size() - 1);

        values.remove(
                values.size() - 1
        );

        if (indexMap.get(val)
                    .isEmpty()) {

            indexMap.remove(val);
        }

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

        RandomizedCollectionDuplicates rc =
                new RandomizedCollectionDuplicates();

        System.out.println(
                rc.insert(1)
        );

        System.out.println(
                rc.insert(1)
        );

        System.out.println(
                rc.insert(2)
        );

        System.out.println(
                rc.remove(1)
        );

        System.out.println(
                rc.getRandom()
        );
    }
          }
