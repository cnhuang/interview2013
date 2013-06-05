package q;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class FindMinSubsetUnsortedArray extends Question {

	@Override
	public String getQuestion() {

		return "Find Min Subset Unsorted Array in a given array. Cracking code interview 17.6";
	}

	@Test(dataProvider = "dataProvider")
	public void findUnsortedArray(Integer[] arr) {

		Log("Input:" + Arrays.toString(arr));

		int middleStart = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] >= arr[i - 1]) {
				middleStart = i;
			} else
				break;
		}

		int middleEnd = arr.length - 1;
		for (int i = arr.length - 2; i >= middleStart; i--) {
			if (arr[i] <= arr[i + 1]) {
				middleEnd = i;
			} else
				break;
		}

		if (middleEnd > middleStart) {

			Log("Initial Middle start:" + middleStart + ", Middle end:"
					+ middleEnd);

			int middleMin = Integer.MAX_VALUE;
			int middleMax = Integer.MIN_VALUE;

			for (int i = middleStart; i <= middleEnd; i++) {

				if (middleMin > arr[i])
					middleMin = arr[i];

				if (middleMax < arr[i])
					middleMax = arr[i];
			}

			for (int i = middleEnd; i < arr.length; i++) {
				if (arr[i] < middleMax)
					middleEnd = i;
			}

			Log("Middle max:" + middleMax + ", Middle min:" + middleMin);

			for (int i = middleStart - 1; i >= 0; i--) {
				if (arr[i] > middleMin) {
					middleStart = i;
				} else
					break;
			}

			for (int i = middleMax - 1; i < arr.length; i++) {
				if (arr[i] < middleMax) {
					middleEnd = i;
				} else
					break;
			}

			Log("Revised Middle start:" + middleStart + ", Middle end:"
					+ middleEnd);
			return;
		}
		Log("Array is sorted already");

	}

	@DataProvider
	public static Object[][] dataProvider() {

		return new Object[][] {
				{ new Integer[] { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 } },
				{ new Integer[] { 1, 2, 4, 7, 10, 11, 12, 5, 6, 7, 16, 18, 19 } },
				{ new Integer[] { 1, 2, 4, 7, 10, 11, 12, 16, 18, 19 } },
				{ new Integer[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } },
				{ new Integer[] { 5, 4, 3, 2, 1, 0 } }, { new Integer[] { 1 } } };
	}

}
