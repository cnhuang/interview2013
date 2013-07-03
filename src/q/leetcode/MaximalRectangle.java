package q.leetcode;

import org.testng.annotations.Test;

import util.Question;

public class MaximalRectangle extends Question {

	@Override
	public String getQuestion() {
		/*
		 * Given a 2D binary matrix filled with 0's and 1's, find the largest
		 * rectangle containing all ones and return its area.
		 */
		return "http://leetcode.com/onlinejudge#question_85";
	}

	@Test
	public void test() {
		Log(maximalRectangle(new char[][] {{ '0', '1' } , { '1', '0' } }));
	}

	public int maximalRectangle(char[][] matrix) {

	

	}
}
