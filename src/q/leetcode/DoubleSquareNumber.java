package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class DoubleSquareNumber extends Question {

	@Override
	public String getQuestion() {
		return "http://leetcode.com/2011/01/double-square-problem-analysis.html";
	}

	@Test
	public void find() {

		int x = 26;

		int upper = 0;

		while (upper * upper < x) {
			upper++;
		}

		int lower = 0;

		while (lower < upper) {

			int sum = lower * lower + upper * upper;

			if (sum == x) {
				Log(lower + "," + upper);
				lower++;
				upper--;
			} else if (sum > x) {
				upper--;
			} else {
				lower++;
			}
		}
	}
}
