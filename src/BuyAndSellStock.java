/**
 * @Author asu
 * @Date 2/26/2020
 * @Description given an array, show the maximum profit that can get by buying and selling stock
 * assume trade only happens once.
 * Example input: [100, 200, 300]
 * output: 200 (buy at 100, sell at 300)
 **/
public class BuyAndSellStock {
    public int getMaxProfit(int[] arr) {
        int maxProfit = Integer.MIN_VALUE;
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[minIndex]) {
                maxProfit = Math.max(maxProfit, arr[i] - arr[minIndex]);
            } else {
                minIndex = i;
            }
        }
        return maxProfit;
    }
}
