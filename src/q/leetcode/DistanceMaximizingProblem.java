package q.leetcode;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class DistanceMaximizingProblem extends Question {

	@Override
	public String getQuestion() {
		return "http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/\n"
				+ "http://leetcode.com/2011/05/a-distance-maximizing-problem.html";
	}

	@Test(dataProvider = "dataProvider")
	public void find(Integer[] arr, Integer ans) {

		int[] leftMin = new int[arr.length];
		int[] rightMax = new int[arr.length];

		leftMin[0] = arr[0];

		for (int i = 1; i < arr.length; i++) {
			leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
		}

		rightMax[arr.length - 1] = arr[arr.length - 1];

		for (int i = arr.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
		}

		int left = 0;
		int right = 0;
		int maxDiff = -1;

		while (left < arr.length && right < arr.length) {

			if (leftMin[left] < rightMax[right]) {
				maxDiff = Math.max(maxDiff, right - left);
				right++;
			} else
				left++;

		}

		Log(maxDiff + "." + ans);
		assertEquals(maxDiff, ans.intValue());
	}

	@DataProvider
	public static Object[][] dataProvider() {
		return new Object[][] {
				{ new Integer[] { 34, 8, 10, 3, 2, 80, 30, 33, 1 }, 6 },

				{ new Integer[] { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 }, 8 },

				{ new Integer[] { 1, 2, 3, 4, 5, 6 }, 5 },

				{ new Integer[] { 6, 5, 4, 3, 2, 1 }, -1 }

		};
	}

}
