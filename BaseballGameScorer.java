import java.util.Stack;

public class BaseballGameScorer {

    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();

        for (String operation : operations) {
            switch (operation) {
                case "+":
                    int last = scores.pop();
                    int secondLast = scores.peek();

                    scores.push(last);
                    scores.push(last + secondLast);
                    break;

                case "D":
                    scores.push(scores.peek() * 2);
                    break;

                case "C":
                    scores.pop();
                    break;

                default:
                    scores.push(Integer.parseInt(operation));
                    break;
            }
        }

        int total = 0;

        for (int score : scores) {
            total += score;
        }

        return total;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// LeetCode: 682 - Baseball Game
