package q.dp;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class PatternSearch extends Question {
	/*
	 * http://www.careercup.com/question?id=13126665
	 * 
	 * You are given a 2D array of characters and a character pattern. WAP to
	 * find if pattern is present in 2D array. Pattern can be in any way (all 8
	 * neighbors to be considered) but you can't use same character twice while
	 * matching. Return 1 if match is found, 0 if not.
	 */

	@Override
	public String getQuestion() {
		return "http://www.careercup.com/question?id=13126665";
	}

	@Test(dataProvider = "dataProvider")
	public void search(char[][] arr, String target) {

		boolean[][] trace = new boolean[arr.length][arr[0].length];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {

				// Important !!!
				if (arr[row][col] == target.charAt(0)) {
					Log("\nStarts row:" + row + ", col:" + col);
					search(arr, target, row, col, trace, 0);
				}
			}
		}
	}

	private void search(char[][] arr, String target, int row, int col, boolean[][] trace, int index) {

		if (col >= arr[0].length)
			col %= arr[0].length;

		if (row >= arr.length)
			row %= arr.length;

		if (col < 0)
			col += arr[0].length;

		if (row < 0)
			row += arr.length;

		if (trace[row][col])
			return;

		// Important - use index is enough
		if (arr[row][col] == target.charAt(index)) {

			// Important!! use index == target.length will print same answer 8
			// times
			if (index == target.length() - 1) {
				for (int i = 0; i < arr.length; i++)
					Log(Arrays.toString(arr[i]) + "\t\t" + Arrays.toString(trace[i]));

				Log("\n\n");
				return;
			}

			trace[row][col] = true;

			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					search(arr, target, row + i, col + j, trace, index + 1);
				}
			}

			trace[row][col] = false;
		}
	}

	@DataProvider
	public static Object[][] dataProvider() {
		char[][] arr = { { 'A', 'C', 'P', 'R', 'C' }, { 'X', 'S', 'O', 'P', 'C' },
				{ 'V', 'O', 'V', 'N', 'I' }, { 'W', 'G', 'F', 'M', 'N' },
				{ 'Q', 'A', 'T', 'I', 'T' } };

		String target = "MICROSOFT";

		return new Object[][] { { arr, target } };
	}

}
