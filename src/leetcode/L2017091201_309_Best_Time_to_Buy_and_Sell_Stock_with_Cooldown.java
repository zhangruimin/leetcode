package leetcode;

/**
 */
public class L2017091201_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        int sell = 0;
        int previousSell = 0;
        int buy = Integer.MIN_VALUE;
        int previousBuy = Integer.MIN_VALUE;

        for (int price : prices) {
            previousBuy = buy;
            buy = Math.max(previousSell - price, previousBuy);
            previousSell = sell;
            sell = Math.max(previousBuy + price, previousSell);
        }
        return sell;

    }
}

