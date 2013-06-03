package question.google;

import java.util.Arrays;
import java.util.Stack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class FindMaxAreaUnderHistogram extends Question {

	@Override
	public String getQuestion() {
		return "http://stackoverflow.com/questions/4311694/maximize-the-rectangular-area-under-histogram";
	}

	@Test(dataProvider = "dataProvider")
	public void find_BruteForce(Integer[] arr) {
		Log("\nInput:" + Arrays.toString(arr));
		int itr = 0;

		int max = Integer.MIN_VALUE;
		int maxIndex = -1;

		for (int i = 0; i < arr.length; i++) {

			int area = 1;

			for (int j = i - 1; j >= 0; j--) {
				itr++;
				if (arr[j] >= arr[i])
					area++;
				else
					break;
			}

			for (int j = i + 1; j < arr.length; j++) {
				itr++;
				if (arr[j] >= arr[i])
					area++;
				else
					break;
			}

			if (max < (area * arr[i])) {
				max = area * arr[i];
				maxIndex = i;
			}
		}

		Log("Max index:" + maxIndex + ", Area:" + max);
		Log("Iteration:" + itr);
	}

	@Test(dataProvider = "dataProvider")
	public void find_quicker(Integer[] arr) {
		Log("\n[Quicker]Input:" + Arrays.toString(arr));
		int itr = 0;

		Stack<Integer> leftBlockers = new Stack<Integer>();
		Stack<Integer> rightBlockers = new Stack<Integer>();

		int[] availableArea = new int[arr.length];
		Arrays.fill(availableArea, 1);

		for (int i = 0; i < arr.length; i++) {

			// for calculate itr only
			if (leftBlockers.empty())
				itr++;

			while (!leftBlockers.empty()) {
				itr++;

				Integer blockerIndex = leftBlockers.peek();

				if (arr[blockerIndex] >= arr[i]) {
					// Not blocker of index i. Popout
					leftBlockers.pop();
				} else {
					// Find a blocker. Area of i is limited by blockerIndex
					availableArea[i] += (i - blockerIndex - 1);
					break;
				}
			}

			if (leftBlockers.empty()) {
				// no blockers are found. All histogram in the left is larger
				// than arr[i]
				availableArea[i] += i; // i - (-1) -1
			}
			// i might become a blocker for the following histogram.
			leftBlockers.push(i);
		}

		// same from the right
		for (int i = arr.length - 1; i >= 0; i--) {

			// for calculate itr only
			if (rightBlockers.empty())
				itr++;

			while (!rightBlockers.empty()) {
				itr++;

				Integer blockerIndex = rightBlockers.peek();

				if (arr[blockerIndex] >= arr[i]) {
					// Not blocker of index i. Popout
					rightBlockers.pop();
				} else {
					// Find a blocker. Area of i is limited by blockerIndex
					availableArea[i] += (blockerIndex - i - 1);
					break;
				}
			}

			if (rightBlockers.empty()) {
				// no blockers are found. All histogram in the right is larger
				// than arr[i]
				availableArea[i] += (arr.length - i - 1);
			}

			// i might become a blocker for the following histogram.
			rightBlockers.push(i);
		}

		int max = Integer.MIN_VALUE;
		int maxIndex = -1;

		for (int i = 0; i < arr.length; i++) {

			if (max < (availableArea[i] * arr[i])) {
				max = availableArea[i] * arr[i];
				maxIndex = i;
			}
		}

		Log("Max index:" + maxIndex + ", Area:" + max);
		Log("Iteration:" + itr);
	}

	@DataProvider
	public static Object[][] dataProvider() {
		return new Object[][] {
				{ new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 } },
				{ new Integer[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 } },
				{ new Integer[] { 1, 2, 3, 4, 5, 4, 3, 2, 1 } },
				{ new Integer[] { 9, 8, 7, 6, 5, 6, 7, 8, 9 } },
				{ new Integer[] { 1, 1, 1, 1, 1, 1, 1, 1 } } };
	}
}
