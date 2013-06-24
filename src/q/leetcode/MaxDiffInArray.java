package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class MaxDiffInArray extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/2010/11/best-time-to-buy-and-sell-stock.html";
	}

	@Test
	public void find() {

		int[] arr = { 1, 2, 3, 5, 3, 4, 13, 6, 54, 12, 3, 21, 2 };

		int minIndex = 0;
		int maxDiff = 0;

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] < arr[minIndex])
				minIndex = i;
			else {
				maxDiff = Math.max(maxDiff, arr[i] - arr[minIndex]);
			}

		}

		Log(maxDiff);

	}

}
