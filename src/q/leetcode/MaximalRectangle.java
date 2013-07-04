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
		// http://wehackcode.wordpress.com/2012/11/26/maximal-rectangle/
		return "http://leetcode.com/onlinejudge#question_85";
	}

	@Test
	public void test() {
		Log(maximalRectangle(new char[][] { { '0', '1' }, { '1', '0' } }));
	}

	public int maximalRectangle(char[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		// transform it to histogram for each row.

		int[][] graph = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix[0].length; i++) {
			graph[0][i] = matrix[0][i] == '1' ? 1 : 0;
		}

		for (int row = 1; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				graph[row][col] = matrix[row][col] == '1' ? graph[row - 1][col] + 1 : 0;
			}
		}

		int area = 0;

		LargestRectangleInHistogram obj = new LargestRectangleInHistogram();

		for (int i = matrix.length - 1; i >= 0; i--) {
			if ((i - 0 + 1) * matrix[0].length <= area)
				break;
			area = Math.max(area, obj.largestRectangleArea(graph[i]));
		}

		return area;

	}
}
