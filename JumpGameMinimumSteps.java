public class JumpGameMinimumSteps {

    public int jump(int[] numbers) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int index = 0;
             index < numbers.length - 1;
             index++) {

            farthest = Math.max(
                    farthest,
                    index + numbers[index]
            );

            if (index == currentEnd) {

                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {

        JumpGameMinimumSteps solver =
                new JumpGameMinimumSteps();

        int[] numbers = {
                2, 3, 1, 1, 4
        };

        System.out.println(
                solver.jump(numbers)
        );
    }
}
