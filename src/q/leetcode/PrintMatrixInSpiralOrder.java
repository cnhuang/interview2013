package q.leetcode;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class PrintMatrixInSpiralOrder extends Question {

	@Override
	public String getQuestion() {
		/*
		 * [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
		 * 
		 * You should return [1,2,3,6,9,8,7,4,5].
		 */
		return "http://leetcode.com/2010/05/printing-matrix-in-spiral-order.html";
	}

	@Test(dataProvider = "dataProvider")
	public void print(int row, int col) {

		int[][] arr = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = col * i + j;
			}
		}

		for (int i = 0; i < row; i++) {
			Log(Arrays.toString(arr[i]));
		}

		int rowS = 0;
		int rowE = row;
		int colS = 0;
		int colE = col;
		StringBuilder sb = new StringBuilder();

		while (rowE > rowS && colE > colS) {

			for (int i = colS; i < colE; i++) {
				print(arr, rowS, i, sb);
			}

			for (int i = rowS + 1; i < rowE - 1; i++) {
				print(arr, i, colE - 1, sb);
			}

			// important
			if (rowE - rowS > 1) {
				for (int i = colE - 1; i >= colS; i--) {
					print(arr, rowE - 1, i, sb);
				}
			}

			// important
			if (colE - colS > 1) {
				for (int i = rowE - 2; i > rowS; i--) {
					print(arr, i, colS, sb);
				}
			}

			rowS++;
			rowE--;
			colS++;
			colE--;

			// Log(sb.toString());
		}

		Log(sb.toString());
	}

	public void print(int[][] arr, int row, int col, StringBuilder sb) {
		sb.append(arr[row][col]).append(",");
		// Log("("+row+","+col+")");
	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] {

		{ 1, 1 },

		{ 2, 2 },

		{ 3, 4 },

		{ 4, 3 },

		{ 6, 1 },

		{ 1, 6 },

		};
	}

}
