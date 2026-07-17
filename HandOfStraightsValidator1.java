import java.util.TreeMap;

public class HandOfStraightsValidator1 {

    public boolean isNStraightHand(
            int[] hand,
            int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> frequency =
                new TreeMap<>();

        for (int card : hand) {

            frequency.put(
                    card,
                    frequency.getOrDefault(card, 0) + 1
            );
        }

        while (!frequency.isEmpty()) {

            int firstCard =
                    frequency.firstKey();

            for (int card = firstCard;
                 card < firstCard + groupSize;
                 card++) {

                Integer count =
                        frequency.get(card);

                if (count == null) {
                    return false;
                }

                if (count == 1) {

                    frequency.remove(card);

                } else {

                    frequency.put(
                            card,
                            count - 1
                    );
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        HandOfStraightsValidator solver =
                new HandOfStraightsValidator();

        int[] hand = {
                1, 2, 3, 6, 2, 3, 4, 7, 8
        };

        System.out.println(
                solver.isNStraightHand(
                        hand,
                        3
                )
        );
    }
}
