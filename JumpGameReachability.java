public class JumpGameReachability {

    public boolean canJump(
            int[] numbers) {

        int farthest = 0;

        for (int index = 0;
             index < numbers.length;
             index++) {

            if (index > farthest) {
                return false;
            }

            farthest = Math.max(
                    farthest,
                    index + numbers[index]
            );

            if (farthest
                    >= numbers.length - 1) {

                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        JumpGameReachability solver =
                new JumpGameReachability();

        int[] numbers = {
                2, 3, 1, 1, 4
        };

        System.out.println(
                solver.canJump(numbers)
        );
    }
}
