package q.leetcode;

import util.Question;

public class BestTimeToSellAndBuyStock3 extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Say you have an array for which the ith element is the price of a
		 * given stock on day i.
		 * 
		 * Design an algorithm to find the maximum profit. You may complete at
		 * most two transactions.
		 * 
		 * Note: You may not engage in multiple transactions at the same time
		 * (ie, you must sell the stock before you buy again).
		 */
		return "http://leetcode.com/onlinejudge#question_123";
	}

	public int maxProfit(int[] prices) {

		if (prices == null || prices.length < 2)
			return 0;

		int profit = 0;

		// for each day, calculate the max profit you can earn if you sell the
		// stock today

		int[] sellProfit = new int[prices.length];
		sellProfit[0] = 0;
		int min = prices[0];

		for (int i = 0; i < prices.length; i++) {

			if (i > 0) {
				sellProfit[i] = Math.max(prices[i] - min, sellProfit[i - 1]);
			}

			min = Math.min(min, prices[i]);
		}

		// for each day, calculate the max profit you can earn if you buy the
		// stock today

		int[] buyProfit = new int[prices.length];
		buyProfit[prices.length - 1] = 0;
		int max = prices[prices.length - 1];

		for (int i = prices.length - 1; i >= 0; i--) {
			
			if(i < prices.length - 1)
				buyProfit[i] = Math.max(max - prices[i], buyProfit[i + 1]);
			
			profit = Math.max(profit, buyProfit[i] + sellProfit[i]);
			max = Math.max(max, prices[i]);
		}

		return profit;

	}

}
