package question.amzn;

import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class FindMaxProductOf3Num extends Question {

	@Override
	public String getQuestion() {
		return "Find the maxProduct of three numbers from a given integer array.";
	}

	@Test(dataProvider = "dataProvider")
	public void findMaxProdcut(Integer[] arr) {

		Log("Input:" + Arrays.toString(arr));

		if (arr == null || arr.length < 3)
			Log("No result");
		else {

			Arrays.sort(arr);

			Log("Max product:"
					+ Math.max(arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3],
							arr[arr.length - 1] * arr[0] * arr[1]));
		}
	}

	@DataProvider(name = "dataProvider")
	public static Object[][] dataProvider() {
		return new Object[][] { { null }, { new Integer[] {} }, { new Integer[] { 1 } },
				{ new Integer[] { 1, 2, 3 } }, { new Integer[] { 0, 1, 2 } },
				{ new Integer[] { -1, 0, 1 } }, { new Integer[] { 0, -1, -2 } },
				{ new Integer[] { -1, -2, -3 } }, { new Integer[] { 3, 2, 1, 0, -1 } },
				{ new Integer[] { 3, 2, 1, 0, -1, -6 } },
				{ new Integer[] { 3, 2, 0, -1, -2, -3 } }, { new Integer[] { 100, 1, -3, -4 } } };
	}
}
