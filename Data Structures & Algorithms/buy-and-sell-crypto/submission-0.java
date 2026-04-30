class Solution {
    public int maxProfit(int[] prices) {
        int buyDate = 0;
        int sellDate = 1;
        int maxProfit = 0;
        int currentProfit = 0;

        while(buyDate < prices.length - 1) {
            int buyPrice = prices[buyDate];          
            sellDate = buyDate + 1;
            
            while(sellDate < prices.length) {
                int sellPrice = prices[sellDate];                             
                currentProfit = sellPrice - buyPrice;
                maxProfit = currentProfit > maxProfit ? currentProfit : maxProfit;

                sellDate++;
            }
            buyDate++;
        }

        return maxProfit;
    }
}
