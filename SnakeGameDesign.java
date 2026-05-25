import java.util.*;

public class SnakeGameDesign {

    int width, height;

    int[][] food;

    int foodIndex;

    LinkedList<int[]> snake;

    Set<String> occupied;

    public SnakeGameDesign(int width,
                           int height,
                           int[][] food) {

        this.width = width;
        this.height = height;
        this.food = food;

        snake = new LinkedList<>();

        snake.add(new int[]{0, 0});

        occupied = new HashSet<>();

        occupied.add("0,0");
    }

    public int move(String direction) {

        int[] head =
                snake.getFirst();

        int r = head[0];
        int c = head[1];

        switch (direction) {

            case "U":
                r--;
                break;

            case "D":
                r++;
                break;

            case "L":
                c--;
                break;

            case "R":
                c++;
                break;
        }

        int[] tail =
                snake.removeLast();

        occupied.remove(
                tail[0] + "," + tail[1]
        );

        if (r < 0 || c < 0 ||
            r >= height ||
            c >= width ||
            occupied.contains(
                    r + "," + c)) {

            return -1;
        }

        snake.addFirst(
                new int[]{r, c}
        );

        occupied.add(r + "," + c);

        if (foodIndex < food.length &&
            r == food[foodIndex][0] &&
            c == food[foodIndex][1]) {

            snake.addLast(tail);

            occupied.add(
                    tail[0] + "," + tail[1]
            );

            foodIndex++;
        }

        return foodIndex;
    }
}
