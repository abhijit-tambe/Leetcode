/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
package p121;

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		int res = 0;
		// O(n2) time complexity
//        for(int i=0;i<prices.length-1;i++){
//            for(int j=i+1;j<prices.length;j++){
//                if(prices[j]>prices[i]){
//                   res = Math.max(res, prices[j]-prices[i]); 
//                }
//            }     
//        }
//		return res;

		// O(n)
		if (prices.length < 1) {
			return res;
		}
		int[] l = new int[prices.length];
		int[] r = new int[prices.length];
		l[0] = prices[0];
		r[prices.length - 1] = prices[prices.length - 1];

		for (int i = 1; i < prices.length; i++) {
			l[i] = Math.min(l[i - 1], prices[i]);
		}
		for (int i = prices.length - 2; i >= 0; i--) {
			r[i] = Math.max(r[i + 1], prices[i]);
		}
		for (int i = 0; i < prices.length; i++) {
			res = Math.max(res, r[i] - l[i]);
		}
		return res;

	}
}
