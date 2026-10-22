import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersMatrix {

    public List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            int minCol = 0;

            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] < matrix[i][minCol]) {
                    minCol = j;
                }
            }

            int candidate = matrix[i][minCol];
            boolean isLucky = true;

            for (int r = 0; r < rows; r++) {
                if (matrix[r][minCol] > candidate) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                result.add(candidate);
            }
        }

        return result;
    }
}

// Time Complexity: O(m × n)
// Space Complexity: O(1) auxiliary space, excluding the result
// LeetCode: 1380 - Lucky Numbers in a Matrix
