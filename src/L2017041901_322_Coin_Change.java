/**
 */
public class L2017041901_322_Coin_Change {

    private static final long MAX_VALUE = Long.MAX_VALUE-1;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        long[] minCoins = new long[amount + 1];

        minCoins[0] = 0;

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            minCoins[currentAmount] = MAX_VALUE;
            for (int coinIndex = 0; coinIndex < coins.length; coinIndex++) {
                if (currentAmount - coins[coinIndex] >= 0) {
                    minCoins[currentAmount] = Math.min(minCoins[currentAmount], minCoins[currentAmount - coins[coinIndex]] + 1);
                }
            }
        }
        if (minCoins[amount] == MAX_VALUE) {
            return -1;
        }
        return (int) minCoins[amount];

    }
}


