package q.leetcode;

import util.Question;

public class BestTimeToSellAndBuyStock2 extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Say you have an array for which the ith element is the price of a
		 * given stock on day i.
		 * 
		 * Design an algorithm to find the maximum profit. You may complete as
		 * many transactions as you like (ie, buy one and sell one share of the
		 * stock multiple times). However, you may not engage in multiple
		 * transactions at the same time (ie, you must sell the stock before you
		 * buy again).
		 */
		return "http://leetcode.com/onlinejudge#question_122";
	}

	public int maxProfit(int[] prices) {

		if (prices == null || prices.length < 2)
			return 0;

		int profit = 0;

		for (int i = 1; i < prices.length; i++) {

			if (prices[i - 1] < prices[i]) {
				profit += prices[i] - prices[i - 1];
			}

		}

		return profit;

	}

}
