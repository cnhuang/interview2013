package q.leetcode;

import java.util.Arrays;

import org.testng.annotations.Test;

import util.Question;

public class RotationImage extends Question {

	@Override
	public String getQuestion() {
		/*
		 * You are given an n x n 2D matrix representing an image.
		 * 
		 * Rotate the image by 90 degrees (clockwise).
		 * 
		 * Follow up: Could you do this in-place?
		 */
		return "http://leetcode.com/onlinejudge#question_48";
	}

	@Test
	public void test() {

		int N = 2;
		int[][] matrix = new int[N][N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				matrix[i][j] = i * N + j + 1;

		Log("\n");
		for (int[] m : matrix) {

			Log(Arrays.toString(m));
		}

		rotate(matrix);
	}

	public void rotate(int[][] matrix) {

		if (matrix == null || matrix.length == 1)
			return;

		for (int i = 0; i < matrix.length / 2; i++) {

			int start = i;
			int end = matrix.length - 1 - i;

			// important, j has to be zero based and only process N-1 element in
			// a row
			for (int j = 0; j < end - start; j++) {

				int tmp = matrix[start][start + j];

				matrix[start][start + j] = matrix[end - j][start];
				matrix[end - j][start] = matrix[end][end - j];
				matrix[end][end - j] = matrix[start + j][end];
				matrix[start + j][end] = tmp;

			}

		}
	}

}
