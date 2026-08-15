public class CoinChangeCombinations {

    public int change(
            int amount,
            int[] coins) {

        int[] combinations =
                new int[amount + 1];

        combinations[0] = 1;

        for (int coin : coins) {

            for (int currentAmount = coin;
                 currentAmount <= amount;
                 currentAmount++) {

                combinations[currentAmount] +=
                        combinations[
                                currentAmount - coin
                        ];
            }
        }

        return combinations[amount];
    }

    public static void main(String[] args) {

        CoinChangeCombinations solver =
                new CoinChangeCombinations();

        int[] coins = {
                1, 2, 5
        };

        System.out.println(
                solver.change(
                        5,
                        coins
                )
        );
    }
}
