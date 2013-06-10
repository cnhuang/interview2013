package q.com.google;

import static org.testng.AssertJUnit.assertEquals;
import java.util.Arrays;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class FindMax1000NumInAnArray extends Question {

	// 1. use heap data structure

	// 2. use sort

	// 3. use quick sort idea. Find a pivot and if left size > 1000 search left
	// side, search right side otherwise. Time complexiy = N + N/2 + N/4 = 2N =
	// O(N)

	@Override
	public String getQuestion() {
		return "http://www.careercup.com/question?id=17693675";
	}

	@Test(dataProvider = "dataProvider")
	public void find_method3(Integer arr[], Integer n, Integer[] sorted) {

		Log("Input:" + Arrays.toString(Arrays.copyOfRange(sorted, 0, 50)));
		find_method3(arr, 0, arr.length - 1, n);
		Integer[] result = Arrays.copyOfRange(arr, 0, 50);
		Log("Result:" + Arrays.toString(result));
		Arrays.sort(result);
		Log("Result Sorted:" + Arrays.toString(result));
		Log("All Input:" + Arrays.toString(arr));

		assertEquals(Arrays.toString(Arrays.copyOfRange(sorted, 0, 50)),
				Arrays.toString(result));

	}

	@DataProvider
	public static Object[][] dataProvider() {

		Integer[] d1 = new Integer[1000];
		Integer[] d2 = new Integer[1000];
		Random rand = new Random(System.currentTimeMillis());

		for (int i = 0; i < d1.length; i++) {
			d1[i] = rand.nextInt(200);
			d2[i] = d1[i];
		}

		Arrays.sort(d2);

		return new Object[][] { { d1, 50, d2 } };

	}

	private void find_method3(Integer[] arr, Integer s, Integer e, Integer n) {

		Log("\nStart:" + s + ", End:" + e);

		if (s > e)
			return;

		int pivot = arr[((int) System.currentTimeMillis() % (e - s + 1)) + s];

		int i = s;
		int j = e;

		while (i <= j) {

			// important i < e
			while (arr[i] < pivot && i <= e)
				i++;

			// important j > s
			while (arr[j] > pivot && j >= s)
				j--;

			if (i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;

				i++;
				j--;
			}
		}
		
		i--;

		Log("Pivot:" + pivot);
		Log("Before Pivot:" + Arrays.toString(Arrays.copyOfRange(arr, 0, i)));
		Log("Working:"
				+ Arrays.toString(Arrays.copyOfRange(arr, s, e + 1)));
		Log("i:" + i + ", N:" + n);

		if (i == (n - 1)) {
			return;
		} else if (i > (n - 1)) {
			// Log("i > n");
			find_method3(arr, s, i, n);
		} else {
			// Log("i < n");
			find_method3(arr, i, e, n);
		}

	}
}
