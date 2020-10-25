// 122. 买卖股票的最佳时机 II

class Solution {
	// 时间复杂度：O(n);空间复杂度：O(1)
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                total += prices[i] - prices[i-1];
            }
        }
        return total;
    }
}