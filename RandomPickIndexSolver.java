import java.util.Random;

public class RandomPickIndexSolver {

    private final int[] numbers;
    private final Random random;

    public RandomPickIndexSolver(
            int[] numbers) {

        this.numbers = numbers;
        this.random = new Random();
    }

    public int pick(
            int target) {

        int chosenIndex = -1;
        int count = 0;

        for (int index = 0;
             index < numbers.length;
             index++) {

            if (numbers[index] == target) {

                count++;

                if (random.nextInt(count) == 0) {

                    chosenIndex = index;
                }
            }
        }

        return chosenIndex;
    }

    public static void main(String[] args) {

        int[] numbers = {
                1,
                2,
                3,
                3,
                3
        };

        RandomPickIndexSolver solver =
                new RandomPickIndexSolver(
                        numbers
                );

        System.out.println(
                solver.pick(3)
        );
    }
}
