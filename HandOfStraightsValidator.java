import java.util.*;

public class HandOfStraightsValidator {

    static boolean isNStraightHand(
            int[] hand,
            int groupSize) {

        if (hand.length %
            groupSize != 0) {

            return false;
        }

        TreeMap<Integer, Integer> map =
                new TreeMap<>();

        for (int card : hand) {

            map.put(
                    card,
                    map.getOrDefault(
                            card,
                            0
                    ) + 1
            );
        }

        while (!map.isEmpty()) {

            int first =
                    map.firstKey();

            for (int i = 0;
                 i < groupSize;
                 i++) {

                int current =
                        first + i;

                if (!map.containsKey(
                        current)) {

                    return false;
                }

                map.put(
                        current,
                        map.get(current) - 1
                );

                if (map.get(current) == 0) {

                    map.remove(current);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] hand =
                {1,2,3,6,2,3,4,7,8};

        System.out.println(
                isNStraightHand(hand, 3)
        );
    }
}
