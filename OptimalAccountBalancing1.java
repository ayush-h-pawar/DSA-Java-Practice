import java.util.ArrayList;
import java.util.List;

public class OptimalAccountBalancing1 {

    public int minTransfers(int[][] transactions) {

        int[] balance = new int[21];

        for (int[] t : transactions) {
            balance[t[0]] -= t[2];
            balance[t[1]] += t[2];
        }

        List<Integer> debt = new ArrayList<>();

        for (int value : balance) {
            if (value != 0) {
                debt.add(value);
            }
        }

        return settle(0, debt);
    }

    private int settle(int start, List<Integer> debt) {

        while (start < debt.size() &&
                debt.get(start) == 0) {
            start++;
        }

        if (start == debt.size()) {
            return 0;
        }

        int answer = Integer.MAX_VALUE;

        for (int i = start + 1;
             i < debt.size();
             i++) {

            if (debt.get(start) * debt.get(i) < 0) {

                debt.set(i,
                        debt.get(i) + debt.get(start));

                answer = Math.min(
                        answer,
                        1 + settle(start + 1, debt));

                debt.set(i,
                        debt.get(i) - debt.get(start));

                if (debt.get(i) + debt.get(start) == 0) {
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        OptimalAccountBalancing solver =
                new OptimalAccountBalancing();

        int[][] transactions = {
                {0, 1, 10},
                {2, 0, 5}
        };

        System.out.println(
                solver.minTransfers(transactions)
        );
    }
}
