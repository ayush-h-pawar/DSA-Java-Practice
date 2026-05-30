import java.util.*;

public class OptimalAccountBalancing {

    static int minTransfers(
            int[][] transactions) {

        Map<Integer, Integer> balance =
                new HashMap<>();

        for (int[] t : transactions) {

            balance.put(
                    t[0],
                    balance.getOrDefault(
                            t[0], 0
                    ) - t[2]
            );

            balance.put(
                    t[1],
                    balance.getOrDefault(
                            t[1], 0
                    ) + t[2]
            );
        }

        List<Integer> debts =
                new ArrayList<>();

        for (int val :
                balance.values()) {

            if (val != 0)
                debts.add(val);
        }

        return settle(debts, 0);
    }

    static int settle(
            List<Integer> debts,
            int start) {

        while (start <
               debts.size() &&
               debts.get(start) == 0) {

            start++;
        }

        if (start ==
            debts.size()) {

            return 0;
        }

        int ans =
                Integer.MAX_VALUE;

        for (int i = start + 1;
             i < debts.size();
             i++) {

            if (debts.get(start) *
                debts.get(i) < 0) {

                debts.set(
                        i,
                        debts.get(i) +
                        debts.get(start)
                );

                ans =
                        Math.min(
                                ans,
                                1 +
                                settle(
                                        debts,
                                        start + 1
                                )
                        );

                debts.set(
                        i,
                        debts.get(i) -
                        debts.get(start)
                );
            }
        }

        return ans;
    }
}
