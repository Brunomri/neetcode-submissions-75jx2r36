class Solution {
    /* This solution has O(n) time and O(1) space */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuy = 101;

        for (int price: prices) {
            if (price < minBuy) {
                minBuy = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minBuy);
            }
        }

        return maxProfit;
    }
}
