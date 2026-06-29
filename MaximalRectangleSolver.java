import java.util.Stack;

public class MaximalRectangleSolver {

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null
                || matrix.length == 0
                || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maximumArea = 0;

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (matrix[row][col] == '1') {
                    heights[col]++;
                } else {
                    heights[col] = 0;
                }
            }

            maximumArea = Math.max(
                    maximumArea,
                    largestRectangle(heights)
            );
        }

        return maximumArea;
    }

    private int largestRectangle(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currentHeight =
                    (i == heights.length)
                            ? 0
                            : heights[i];

            while (!stack.isEmpty()
                    && currentHeight
                    < heights[stack.peek()]) {

                int height =
                        heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(
                        maxArea,
                        height * width
                );
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        MaximalRectangleSolver solver =
                new MaximalRectangleSolver();

        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println(
                solver.maximalRectangle(matrix)
        );
    }
}
