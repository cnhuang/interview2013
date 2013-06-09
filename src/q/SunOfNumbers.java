package q;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import util.Question;

public class SunOfNumbers extends Question {

	@Override
	public String getQuestion() {
		return "Find 2 or 3 numbers add up to a given Sum";
	}

	@Test(dataProvider = "dataProvider")
	public void find(Integer[] arr, Integer sum) {
		Arrays.sort(arr);
		Log("Find sum " + sum + " in " + Arrays.toString(arr));

		Log("Find 2 numbers sum to " + sum);
		List<Integer[]> result = find2Numbers(arr, sum);

		for (Integer[] tmp : result) {
			Log(Arrays.toString(tmp));
		}

		Log("\n\nFind 3 numbers sum to " + sum);
		result = find3Numbers(arr, sum);

		for (Integer[] tmp : result) {
			Log(Arrays.toString(tmp));
		}
	}

	private List<Integer[]> find2Numbers(Integer[] arr, Integer sum) {

		List<Integer[]> result = new LinkedList<Integer[]>();

		Arrays.sort(arr);

		int i = 0;
		int j = arr.length - 1;

		while (i != j) {
			if (arr[i] + arr[j] == sum) {
				result.add(new Integer[] { arr[i], arr[j] });

				i++;
				j--;
			} else if (arr[i] + arr[j] < sum) {
				i++;
			} else {
				j--;
			}
		}

		return result;
	}

	private List<Integer[]> find3Numbers(Integer[] arr, Integer sum) {

		List<Integer[]> result = new LinkedList<Integer[]>();

		for (int i = 0; i < arr.length - 2; i++) {
			List<Integer[]> tmp = find2Numbers(Arrays.copyOfRange(arr, i + 1, arr.length - 1), sum
					- arr[i]);

			for (Integer[] tmpArr : tmp) {
				result.add(new Integer[] { arr[i], tmpArr[0], tmpArr[1] });
			}
		}

		return result;

	}

	@DataProvider
	public static Object[][] dataProvider() {

		Integer[] numbers = { 5, 7, 2, 8, 3, 4, -2, 5, -2, -45, -3, -1, 17, 28 };
		return new Object[][] { { numbers, 0 } };
	}
}
