import java.util.Stack;

public class AsteroidCollisionSimulator {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack =
                new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty()
                    && asteroid < 0
                    && stack.peek() > 0) {

                if (stack.peek() < -asteroid) {

                    stack.pop();

                } else if (stack.peek() == -asteroid) {

                    stack.pop();
                    destroyed = true;
                    break;

                } else {

                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result =
                new int[stack.size()];

        for (int i = result.length - 1;
             i >= 0;
             i--) {

            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {

        AsteroidCollisionSimulator solver =
                new AsteroidCollisionSimulator();

        int[] asteroids = {
                5,
                10,
                -5
        };

        int[] answer =
                solver.asteroidCollision(asteroids);

        for (int value : answer) {
            System.out.print(value + " ");
        }
    }
}
