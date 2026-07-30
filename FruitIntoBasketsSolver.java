import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasketsSolver {

    public int totalFruit(
            int[] fruits) {

        Map<Integer, Integer> basket =
                new HashMap<>();

        int left = 0;
        int maximumFruits = 0;

        for (int right = 0;
             right < fruits.length;
             right++) {

            basket.put(
                    fruits[right],
                    basket.getOrDefault(
                            fruits[right],
                            0
                    ) + 1
            );

            while (basket.size() > 2) {

                basket.put(
                        fruits[left],
                        basket.get(fruits[left]) - 1
                );

                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }

                left++;
            }

            maximumFruits =
                    Math.max(
                            maximumFruits,
                            right - left + 1
                    );
        }

        return maximumFruits;
    }

    public static void main(String[] args) {

        FruitIntoBasketsSolver solver =
                new FruitIntoBasketsSolver();

        int[] fruits = {
                1,
                2,
                1,
                2,
                3,
                2,
                2
        };

        System.out.println(
                solver.totalFruit(
                        fruits
                )
        );
    }
}
