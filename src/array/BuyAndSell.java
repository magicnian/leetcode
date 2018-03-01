package array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * <p>
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * <p>
 * In this case, no transaction is done, i.e. max profit = 0.
 * Created by liunn on 2018/3/1.
 */
public class BuyAndSell {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
//        function1(prices);
//        function2(prices);
        System.out.println(function3(prices));
    }

    /**
     * 暴力循环
     * 空间复杂度 O(1)-两个变量 max,t
     * 时间复杂度 O(n^2)-loop runs n*(n-1)/2
     *
     * @param prices
     * @return
     */
    public static int function1(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int t = prices[j] - prices[i];
                if (t > max) {
                    max = t;
                }
            }
        }

        return max;
    }

    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param prices
     * @return
     */
    public static int function2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    /**
     * 算法思路参考了max sub array
     * @param prices
     * @return
     */
    public static int function3(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
