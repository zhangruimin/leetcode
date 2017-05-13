/**
 */
public class L2017051304_441_Arranging_Coins {

    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(8.0 * n + 1) - 1) / 2);
    }

    public int arrangeCoins_mine(int n) {
        int coins = 0;
        int k = 0;
        while (coins <= n && coins + k > coins) {
            k++;
            coins = coins + k;
        }
        return k - 1;
    }
}





